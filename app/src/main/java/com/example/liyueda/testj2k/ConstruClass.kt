package com.example.liyueda.testj2k

import java.lang.IllegalArgumentException

/**
 * @author:       Lee
 * @version:      v1.0
 * @package:      com.example.liyueda.testj2k
 * @description:  TODO
 * @date:         2019-08-28
 * @time:         15:15
 */
class ConstruClass constructor(str: String) {
    internal var name = str
    var mys: String

    init {
        mys = str
    }
}

class Cost(var name: String) {

}

class Const constructor(name: String) {

    constructor(name: String, id: Int) : this(name) {
        println("name = $name id = $id")
    }

    constructor(name: String, id: Int, age: Int) : this(name, id) {
        println("name = $name id = $id age = $age")
    }

    init {
        println("name = $name")
    }
}

fun doseth(name: String = "lee", age: Int, pwd: String = "123", member: String = "men") =
    println("name = $name age = $age pwd = $pwd member = $member")

fun nesting(user: String, pwd: String, illegalStr: String) {
    fun validate(value: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(illegalStr)
        }
    }
    validate(user)
    validate(pwd)

    require(user.isNotEmpty()) { illegalStr }
    require(user.isNotEmpty()) { illegalStr }
}

val name = "lee"
val myName = "test"

val text = """
        |Hi, $name!
    |My name is $myName\n
""".trimMargin()

val arr = intArrayOf(1, 23, 4)
val list = listOf<Int>(1, 2, 3, 4)

val sequence = sequenceOf(1, 2, 3, 4)
val result = sequence
    .map { i ->
        println("Map $i")
        i * 2
    }
    .filter { i ->
        println("Filter $i")
        i % 2 == 0
    }


fun testWhen(x: Int) {
    when (x) {
        in 1..10 -> println("in 10")
        in 10..20 -> println("in 20")
        !in 10..20 -> println("!in 20")
        else -> println("else")
    }

}

var flag:Boolean = false

fun main() {
  testWhen(4)

}