package com.example.liyueda.learnkt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import com.example.liyueda.learnkt.databinding.Activity2TestloaderBinding
import com.example.liyueda.learnkt.databinding.ActivityTestloaderBinding

/**
 * @author:       Lee
 * @version:      v1.0
 * @package:      com.example.liyueda.learnkt
 * @date:         2020-04-08
 * @time:         10:17
 */
class TestClassLoader2Activity : AppCompatActivity() {
    private val TAG = "TestClassLoaderActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var mBinding = Activity2TestloaderBinding.inflate(LayoutInflater.from(this), null, false)
        setContentView(mBinding.root)
//        init()
    }

    private fun init() {
        val gsonUtil = GsonUtil()
        gsonUtil.print()
        var b = 1
    }
}