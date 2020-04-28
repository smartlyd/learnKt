package com.example.liyueda;

import android.util.Log;

/**
 * @author: Lee
 * @version: v1.0
 * @package: com.example.liyueda
 * @description: TODO
 * @date: 2020-04-08
 * @time: 14:52
 */
public class MyClassLoader extends ClassLoader {

    private static final String TAG = "MyClassLoader";
    private final String GSON_CLASS_PRE = "com.google.gson.Gson";

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Log.d(TAG, "load class name = " + name);
        return super.loadClass(name);
    }
}