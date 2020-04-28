package com.example.liyueda.learnkt;

import android.content.Context;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: Lee
 * @version: v1.0
 * @package: com.example.liyueda.learnkt
 * @description: TODO
 * @date: 2020-04-08
 * @time: 10:35
 */
public class HookClassHelper {
    private static final String TAG = "HookClassHelper";

    public static boolean hookClassLoader(Context context, ClassLoader appClassLoaderNew) {
        try {
            Field packageInfoField = Class.forName("android.app.ContextImpl").getDeclaredField("mPackageInfo");
            packageInfoField.setAccessible(true);
            Object loadedApkObject = packageInfoField.get(context);
            Class LoadedApkClass = Class.forName("android.app.LoadedApk");
            Method getClassLoaderMethod = LoadedApkClass.getDeclaredMethod("getClassLoader");
//            ClassLoader appClassLoaderOld = (ClassLoader) getClassLoaderMethod.invoke(loadedApkObject);
            Field appClassLoaderField = LoadedApkClass.getDeclaredField("mClassLoader");
            appClassLoaderField.setAccessible(true);
            appClassLoaderField.set(loadedApkObject, appClassLoaderNew);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "error = " + e.getMessage());
        }
        return false;
    }
}
