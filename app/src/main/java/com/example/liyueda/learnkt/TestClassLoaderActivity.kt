package com.example.liyueda.learnkt

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import com.example.liyueda.ConstraintLayoutActivity.CustomDexClassLoader
import com.example.liyueda.MyApp
import com.example.liyueda.Util
import com.example.liyueda.learnkt.databinding.ActivityTestloaderBinding
import java.io.File

/**
 * @author:       Lee
 * @version:      v1.0
 * @package:      com.example.liyueda.learnkt
 * @date:         2020-04-08
 * @time:         10:17
 */
class TestClassLoaderActivity : AppCompatActivity() {
    private val TAG = "TestClassLoaderActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var mBinding = ActivityTestloaderBinding.inflate(LayoutInflater.from(this), null, false)
        setContentView(mBinding.root)
        init()
    }

    private fun init() {
        var myLoader = classLoader

        val cacheFile = Util.getCacheDir(this)
        val internalPath =
            cacheFile.absolutePath + File.separator + "app-debug.apk"
        Log.e("tag", "路径：" + internalPath + "," + File.separator)
        val desFile = File(internalPath)
        try {
            if (!desFile.exists()) {
                desFile.createNewFile()
                //                copyFiles(this, "gson-2.8.6-px.jar", desFile);
                Util.copyFiles(this, "app-debug.apk", desFile)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val customDexClassLoader =
            CustomDexClassLoader(internalPath, cacheFile.absolutePath, null, classLoader)
        val b = HookClassHelper.hookClassLoader(this.baseContext, customDexClassLoader)
        Log.d(TAG, "hook result = $b")
        Log.d(TAG, "attachBaseContext")

        var util = GsonUtil()
//        customDexClassLoader.findClass("com.example.liyueda.learnkt.GsonUtil")
        util.print()
        var a = 1
    }
}