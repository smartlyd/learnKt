package com.example.mylibrary.ktinterface

import com.example.mylibrary.ktinterface.data.DataClass
import com.example.mylibrary.ktinterface.data.NormalClass

/**
 * @author:       Lee
 * @version:      v1.0
 * @package:      com.example.mylibrary.ktinterface
 * @description:  TODO
 * @date:         2019/3/20
 * @time:         10:26 AM
 */
class InMainClass {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {


            val normal = NormalClass("liyueda",12)
            println("normal = ${normal.toString()}")
        }

        fun C.foo(i: Int) {
            println("eeeeeeeee")
        }

        fun <T> MutableList<T>.remove(index1: Int, index2: Int) {
            this.remove(this[index1])
            this.remove(this[index2])
        }

        fun MutableList<Int>.swap(index1: Int, index2: Int) {
            val tmp = this[index1]
            this[index1] = this[index2]
            this[index2] = tmp
        }
    }


}


open class C {
    fun foo() {
        println("ccccc")
    }
}
