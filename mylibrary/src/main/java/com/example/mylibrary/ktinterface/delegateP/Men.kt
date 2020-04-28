package com.example.mylibrary.ktinterface.delegateP

/**
 * @author:       Lee
 * @version:      v1.0
 * @package:      com.example.mylibrary.ktinterface.delegateP
 * @description:  TODO
 * @date:         2019/4/3
 * @time:         11:26 AM
 */
class Men(val sex: Int) : Human {
    override fun eat() {
        println("men eat something...")
    }

    fun smoking(): Unit {
        println("men like smoke...")
    }
}