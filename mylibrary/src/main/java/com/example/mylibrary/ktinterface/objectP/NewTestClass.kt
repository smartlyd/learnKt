package com.example.mylibrary.ktinterface.objectP

/**
 * @author:       Lee
 * @version:      v1.0
 * @package:      com.example.mylibrary.ktinterface.objectP
 * @description:  TODO
 * @date:         2019/3/27
 * @time:         4:38 PM
 */
class NewTestClass {
  companion object ins{
       fun create():NewTestClass = NewTestClass()
   }
    fun testSingle():Unit{
        SingleTon.getInstance()
    }
    fun printsth(){
        println("print some thing...")
    }
}