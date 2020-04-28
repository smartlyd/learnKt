package com.example.liyueda.learnkt

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.lang.reflect.Type


/**
 * @author:       Lee
 * @version:      v1.0
 * @package:      com.example.liyueda.learnkt
 * @description:  TODO
 * @date:         2020-04-08
 * @time:         10:23
 */
class GsonUtil2 {
    private val TAG = "GsonUtil2"
    var sGson: Gson

    constructor() {
        sGson = GsonBuilder().serializeNulls().setLenient().create()
        Log.d(TAG, "in px constructor")
    }


    fun toJson(o: Any?): String? {
        return sGson.toJson(o)
    }

    fun print() {

        Log.d(TAG,"gsonutil2")

    }

    fun <T> fromJson(json: String?, cls: Class<T>?): T {
        return sGson.fromJson(json, cls)
    }

    fun gson(): Gson? {
        return sGson
    }

    fun <T> fromJson(json: String?, typeOfT: Type?): T {
        Log.d(TAG, "from json")
        return sGson.fromJson(json, typeOfT)
    }
}