package com.example.mylibrary.ktinterface.data

/**
 * @author:       Lee
 * @version:      v1.0
 * @package:      com.example.mylibrary.ktinterface.data
 * @description:  TODO
 * @date:         2019/3/25
 * @time:         10:18 AM
 */
sealed class SealdClass public
open class Const(var number: Double) : SealdClass()
data class Sum(val e: SealdClass, val s: SealdClass) : SealdClass()
object NotANumber : SealdClass()