package com.example.mylibrary.ktinterface.delegateP

/**
 * @author:       Lee
 * @version:      v1.0
 * @package:      com.example.mylibrary.ktinterface.delegateP
 * @description:  TODO
 * @date:         2019/4/3
 * @time:         11:28 AM
 */
class Women(val sex: Int) : Human {
    override fun eat() {
        println("women eat something...")
    }

    fun makeup(): Unit {
        println("women like makeup...")
    }
}