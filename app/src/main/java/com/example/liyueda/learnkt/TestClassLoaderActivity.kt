package com.example.liyueda.learnkt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import com.example.leelib.JarTest
import com.example.liyueda.ConstraintLayoutActivity.CustomDexClassLoader
import com.example.liyueda.MyApp
import com.example.liyueda.Util
import com.example.liyueda.learnkt.databinding.ActivityTestloaderBinding
import java.io.File
import java.lang.Error
import java.lang.Exception

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
        try {
            JarTest().create().calculate()
        } catch (e: Exception) {
            Log.e(TAG, "e = ${e.message}")
        } catch (e: Error) {
            Log.e(TAG, "e = ${e.message}")
        }
    }
}