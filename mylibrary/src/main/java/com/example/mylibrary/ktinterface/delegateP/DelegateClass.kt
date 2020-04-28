package com.example.mylibrary.ktinterface.delegateP

import org.jetbrains.anko.db.INTEGER

/**
 * @author:       Lee
 * @version:      v1.0
 * @package:      com.example.mylibrary.ktinterface.delegateP
 * @description:  TODO
 * @date:         2019/4/3
 * @time:         11:34 AM
 */
class DelegateClass {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var men: Human = Men(0);
            var women: Human = Women(1);
            var list = listOf(1, 3, 4, 5, 6)
            list.fold(0, { acc: Int, i: Int ->
                println("acc = $acc,i = $i")
                val result = acc * i
                println("result = $result")
                result
            })
            println("list = $list")
        }


    }
}