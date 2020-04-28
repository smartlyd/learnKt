package com.example.mylibrary.ktinterface.objectP

/**
 * @author:       Lee
 * @version:      v1.0
 * @package:      com.example.mylibrary.ktinterface.objectP
 * @description:  TODO
 * @date:         2019/3/27
 * @time:         4:32 PM
 */
class TestObjectClass {
    companion object {
        @JvmStatic
        fun main(args:Array<String>){
            SingleTon.getInstance()
            SingleTon.getInstance()
            var testN:NewTestClass = NewTestClass()
            testN.testSingle()
            NewTestClass.create().printsth()
        }
    }

}