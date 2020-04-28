package com.example.mylibrary.ktinterface

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author:       Lee
 * @version:      v1.0
 * @package:      com.example.mylibrary.ktinterface
 * @description:
 * @date:         2019/3/22
 * @time:         9:51 AM
 */
class TestFun {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }
    }
}


fun main(){
    println("===start===")

    GlobalScope.launch {
        println(System.currentTimeMillis())
        delay(1000)
        println(System.currentTimeMillis())
        println("after")
    }
    println("in main")
    runBlocking {
        delay(2000)
    }
    println("after blocking")
}