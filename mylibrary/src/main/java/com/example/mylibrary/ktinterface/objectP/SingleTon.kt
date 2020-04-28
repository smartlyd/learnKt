package com.example.mylibrary.ktinterface.objectP

/**
 * @author:       Lee
 * @version:      v1.0
 * @package:      com.example.mylibrary.ktinterface.objectP
 * @description:  TODO
 * @date:         2019/3/27
 * @time:         4:31 PM
 */
object SingleTon {
    fun getInstance():Unit{
       println("getInstance this.name = $this()")
    }
}