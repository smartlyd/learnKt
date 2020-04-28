package com.example.mylibrary.ktinterface.tPack

/**
 * @author:       Lee
 * @version:      v1.0
 * @package:      com.example.mylibrary.ktinterface.tPack
 * @description:  测试泛型
 * @date:         2019/3/25
 * @time:         11:08 AM
 */
class TClass {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val box = Box(1)
            val box2 = Box("box")
            box.convert()
            box2.convert()
        }
    }
}