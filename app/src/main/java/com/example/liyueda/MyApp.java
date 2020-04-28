package com.example.liyueda;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.example.liyueda.learnkt.HookClassHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import dalvik.system.DexClassLoader;

/**
 * @author: Lee
 * @version: v1.0
 * @package: com.example.liyueda
 * @description: TODO
 * @date: 2020-04-08
 * @time: 14:31
 */
public class MyApp extends Application {

    private static final String TAG = "MyApp";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        File cacheFile = getCacheDir(base);
//        String internalPath = cacheFile.getAbsolutePath() + File.separator + "app-debug.apk";
//        Log.e("tag", "路径：" + internalPath + "," + File.separator);
//        File desFile = new File(internalPath);
//        try {
//            if (!desFile.exists()) {
//                desFile.createNewFile();
//                copyFiles(this, "app-debug.apk", desFile);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ConstraintLayoutActivity.CustomDexClassLoader customDexClassLoader =
//                new ConstraintLayoutActivity.CustomDexClassLoader(internalPath, cacheFile.getAbsolutePath(), null, getClassLoader());
//        try {
//            Class<?> aClass = customDexClassLoader.findClass("com.example.liyueda.learnkt.GsonUtil");
//        } catch (Exception e) {
//            Log.e(TAG, "err = " + e.getMessage());
//        }
//        boolean b = HookClassHelper.hookClassLoader(base, customDexClassLoader);
//        Log.d(TAG, "hook result = " + b);
//        Log.d(TAG, "attachBaseContext");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }


    public boolean hasExternalStorage() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取缓存路径
     *
     * @param context
     * @return 返回缓存文件路径
     */
    public File getCacheDir(Context context) {
        File cache;
        if (hasExternalStorage()) {
            cache = context.getExternalCacheDir();
        } else {
            cache = context.getCacheDir();
        }
        if (!cache.exists())
            cache.mkdirs();
        return cache;
    }

    public void copyFiles(Context context, String fileName, File desFile) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = context.getApplicationContext().getAssets().open(fileName);
            out = new FileOutputStream(desFile.getAbsolutePath());
            byte[] bytes = new byte[1024];
            int i;
            while ((i = in.read(bytes)) != -1)
                out.write(bytes, 0, i);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
                if (out != null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}