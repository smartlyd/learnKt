package com.example.leelib2;

import android.util.Log;

/**
 * @author: Lee
 * @version: v1.0
 * @package: com.example.leelib
 * @description: TODO
 * @date: 2020-04-28
 * @time: 16:11
 */
public class JarTest {
    private static final String TAG = "JarTest";

    public JarTest() {
        Log.i(TAG, "JarTest2 is created");
    }

    public JarTest create() {
        return new JarTest();
    }

    public void calculate() {
        Log.i(TAG, "result = " + 7);
    }
}
