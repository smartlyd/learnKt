package com.example.mylibrary.ktinterface.tPack

/**
 * @author:       Lee
 * @version:      v1.0
 * @package:      com.example.mylibrary.ktinterface.tPack
 * @description:  TODO
 * @date:         2019/3/25
 * @time:         11:04 AM
 */
class Box<T>(t: T) {
    var v = t;
    fun convert() {
        var value = v;
        println("value = $value")
    }

    inner class Inner{
        var c = v
    }
}