import org.objectweb.asm.*
import org.objectweb.asm.commons.AdviceAdapter
import utils.LogUtils
import java.io.FileInputStream
import java.io.FileOutputStream
import java.lang.Class
import java.lang.Exception
import java.lang.Class as Class1

class AddCostTime {
    companion object {
        const val TAG = "GetCostTime"
    }

    fun addCostTime(className: String, filePath: String, outPath: String, methodName: String) {
        LogUtils.d("className = $className, filePath = $filePath", TAG)
        try {
            //初始化字节数组
            val inputStream = FileInputStream(filePath)
            //初始化ClassReader 用于读取字节数组
            val classReader = ClassReader(inputStream)
            //初始化ClassWriter用于修改
            val classWriter = ClassWriter(classReader, ClassWriter.COMPUTE_MAXS)
            //初始化个人Visitor，用于修改
            val changeVisitor = ChangeVisitor(classWriter)
            classReader.accept(changeVisitor, ClassReader.EXPAND_FRAMES)
            val clazz = MyClassLoader().defineClass(className, classWriter.toByteArray())
            val newInstance = clazz?.newInstance()
            val declaredMethod = clazz?.getDeclaredMethod(methodName)
            declaredMethod?.invoke(newInstance)
            LogUtils.d("get class success", TAG)

            //获取修改后的字节数组
            val code = classWriter.toByteArray()
            //将字节数组输出到指定位置
            try {
                val fos = FileOutputStream(outPath)
                fos.write(code)
                fos.close()
            } catch (e: Exception) {
                e.printStackTrace()
                LogUtils.d("write failure", TAG)
            }
            LogUtils.d("write success", TAG)
        } catch (e: Exception) {
            e.printStackTrace()
            LogUtils.d("read failure", TAG)
        }
    }
}

class MyClassLoader() : ClassLoader() {
    fun defineClass(name: String, b: ByteArray): Class<*>? {
        return super.defineClass(name, b, 0, b.size)
    }

}

class ChangeVisitor(private var visitor: ClassVisitor, api: Int = Opcodes.ASM5) : ClassVisitor(api, visitor) {

    override fun visitMethod(
        access: Int, name: String?, descriptor: String?, signature: String?, exceptions: Array<out String>?
    ): MethodVisitor {
        val methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions)
        return if (name.equals("<init>")) {
            //如果是初始化，使用默认MethodVisitor
            methodVisitor
        } else {
            ChangeAdapter(Opcodes.ASM4, methodVisitor, access, name, descriptor)
        }
    }
}

class ChangeAdapter(
    private var api: Int,
    private var methodVisitor: MethodVisitor?,
    private var access: Int,
    private var name: String?,
    private var descriptor: String?
) : AdviceAdapter(api, methodVisitor, access, name, descriptor) {
    private var startTimeId : Int = -1

    override fun onMethodEnter() {
        super.onMethodEnter()
        startTimeId = newLocal(Type.LONG_TYPE)
        methodVisitor?.visitMethodInsn(
            Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false
        )
        methodVisitor?.visitIntInsn(Opcodes.LSTORE, startTimeId)

    }

    override fun onMethodExit(opCode: Int) {
        super.onMethodExit(opCode)
        val durationId: Int = newLocal(Type.LONG_TYPE)
        methodVisitor?.visitMethodInsn(
            Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false
        )
        methodVisitor?.visitVarInsn(Opcodes.LLOAD, startTimeId)
        methodVisitor?.visitInsn(Opcodes.LSUB)
        methodVisitor?.visitVarInsn(Opcodes.LSTORE, durationId)
        methodVisitor?.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;")
        methodVisitor?.visitTypeInsn(NEW, "java/lang/StringBuilder");
        methodVisitor?.visitInsn(DUP);
        methodVisitor?.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);
        methodVisitor?.visitLdcInsn("The cost time of $name is");
        methodVisitor?.visitMethodInsn(
            INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false
        )
        methodVisitor?.visitVarInsn(Opcodes.LLOAD, durationId)
        methodVisitor?.visitMethodInsn(
            INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(J)Ljava/lang/StringBuilder;", false
        )
        methodVisitor?.visitMethodInsn(
            INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false
        )
        methodVisitor?.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)
        methodVisitor?.visitEnd()
    }
}
