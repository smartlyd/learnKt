package com.example.mylibrary.ktinterface

/**
 * @author:       Lee
 * @version:      v1.0
 * @package:      com.example.mylibrary.ktinterface
 * @description:  TODO
 * @date:         2019/3/20
 * @time:         10:23 AM
 */
class KtInterfaceClass : MyInterface,MyInterface2 {

    internal val s:Int = 4
    override fun foo() {
        super.foo()
        println("in ktclass foo")
    }
    override fun bar(){
        super<MyInterface>.bar()
        super<MyInterface2>.bar()
        println("after bar")
    }
}