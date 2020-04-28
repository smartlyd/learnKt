package com.example.liyueda

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
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

                if (name != null && name.contains("com.example.leelib")) {
                    name.replace("com.example.leelib", "com.example.leelib2")
                }
                Log.d(TAG, "super name - " + name)
                clazz = super.loadClass(name)
            } catch (ex: Exception) {
            }
            Log.d(TAG, "clazz = $clazz")
            val loadClass = mParentClassLoader?.loadClass(name)
            Log.d(TAG, "loadClass = $loadClass")
            return clazz ?: loadClass
        }

        companion object {
            private const val TAG = "CustomDexClassLoader"
            private const val GSON_CLASS_PRE = "com.google.gson"
        }

    }


    fun onClick(v: View): Unit {
        startActivity(Intent(this, TestClassLoaderActivity::class.java))
    }
}