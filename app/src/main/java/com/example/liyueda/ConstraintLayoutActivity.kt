package com.example.liyueda

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.example.liyueda.learnkt.HookClassHelper
import com.example.liyueda.learnkt.R
import com.example.liyueda.learnkt.TestClassLoaderActivity
import com.example.liyueda.learnkt.databinding.ActivityConstraintBinding
import dalvik.system.DexClassLoader
import java.io.*

/**
 * @author:       Lee
 * @version:      v1.0
 * @package:      com.example.liyueda
 * @description:  TODO
 * @date:         2019-06-24
 * @time:         15:05
 */
class ConstraintLayoutActivity : AppCompatActivity() {
    val TAG = "ConstraintLayoutActivity"

    lateinit var mbinding: ActivityConstraintBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var view = LayoutInflater.from(this).inflate(R.layout.activity_constraint, null)
        mbinding = ActivityConstraintBinding.bind(view)
        mbinding.setLifecycleOwner(this)
        mbinding.activity = this

//        var cacheFile: File = getCacheDir(getApplicationContext());
//        var internalPath = cacheFile.getAbsolutePath() + File.separator + "gson-2.8.6-px.jar";
//        Log.e("tag", "路径：" + internalPath + "," + File.separator);
//        var desFile = File(internalPath);
//        try {
//            if (!desFile.exists()) {
//                desFile.createNewFile();
//                copyFiles(this, "gson-2.8.6-px.jar", desFile);
//            }
//        } catch (e: Exception) {
//            e.printStackTrace();
//        }
//
//        var customDexClassLoader =
//            CustomDexClassLoader(internalPath, cacheFile.getAbsolutePath(), null, classLoader)
//        val b = HookClassHelper.hookClassLoader(baseContext, customDexClassLoader)
//        Log.d(TAG, "hook result = $b")
        setContentView(mbinding.root)
    }

    internal class CustomDexClassLoader(
        dexPath: String?,
        optimizedDirectory: String?,
        librarySearchPath: String?,
        private val mParentClassLoader: ClassLoader?
    ) :
        DexClassLoader(
            dexPath,
            optimizedDirectory,
            librarySearchPath,
            object : ClassLoader() {
                @Throws(ClassNotFoundException::class)
                override fun loadClass(name: String): Class<*>? {
                    Log.d(TAG, "p name = $name")
                    return if (name != null && name.startsWith(GSON_CLASS_PRE)) {
                        null
                    } else {
                        super.loadClass(name)
                    }
                }
            }) {

        @Throws(ClassNotFoundException::class)
        override fun loadClass(name: String): Class<*>? {
            var name: String? = name
            var clazz: Class<*>? = null
            Log.d(TAG, "c name = $name")
            val loadedClass = findLoadedClass(name)
            Log.d(TAG, "loadedClass = $loadedClass")
            try {
                if (name != null && !name.contains("com.google.gson.px") && name.startsWith(GSON_CLASS_PRE)) {
                    name = name.replace("com.google.gson", "com.google.gson.px")
                }
                if (name != null && name.equals("com.example.liyueda.learnkt.TestClassLoaderActivity")) {
                    name = "com.example.liyueda.learnkt.TestClassLoader2Activity"
                }
//                if (name != null && name.equals("com.example.liyueda.learnkt.GsonUtil")) {
//                    name = "com.example.liyueda.learnkt.GsonUtil2"
//                }
                Log.d(TAG, "super name - " + name)
                clazz = super.loadClass(name)
            } catch (ex: Exception) {
            }
            Log.d(TAG, "clazz = $clazz")
            val loadClass = mParentClassLoader?.loadClass(name)
            Log.d(TAG, "loadClass = $loadClass")
            return clazz ?: loadClass
        }

//        public override fun findClass(name: String?): Class<*> {
//            Log.d(TAG, "find name = $name")
//            if (name != null && name.equals("com.example.liyueda.learnkt.GsonUtil")) {
//                return loadClass(name)!!
//            }
//            val findClass = super.findClass(name)
//            Log.d(TAG, "find  = $findClass")
//            return findClass
//        }

        companion object {
            private const val TAG = "CustomDexClassLoader"
            private const val GSON_CLASS_PRE = "com.google.gson"
        }

    }


    fun onClick(v: View): Unit {
        startActivity(Intent(this, TestClassLoaderActivity::class.java))
    }


    fun hasExternalStorage(): Boolean {
        return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
    }

    /**
     * 获取缓存路径
     *
     * @param context
     * @return 返回缓存文件路径
     */
    fun getCacheDir(context: Context): File {
        val cache: File
        cache = if (hasExternalStorage()) {
            context.externalCacheDir
        } else {
            context.cacheDir
        }
        if (!cache.exists()) cache.mkdirs()
        return cache
    }

    fun copyFiles(
        context: Context,
        fileName: String?,
        desFile: File
    ) {
        var `in`: InputStream? = null
        var out: OutputStream? = null
        try {
            `in` = context.applicationContext.assets.open(fileName)
            out = FileOutputStream(desFile.absolutePath)
            val bytes = ByteArray(1024)
            var i: Int
            while (`in`.read(bytes).also { i = it } != -1) out.write(bytes, 0, i)
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                `in`?.close()
                out?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}