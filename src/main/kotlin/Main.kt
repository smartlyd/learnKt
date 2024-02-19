import java.text.DecimalFormat

class Main {
}

data class Book(var name:String)

fun main() {
    val list = listOf<Book>()
    println("size = ${list.size}")

    if(list.isNotEmpty()){
        println(list?.get(0)?.name)
    }else{
        println("list is empty")
    }
    productError()
    productNPE()
}

fun productError(){
    val array = arrayOf(1, 2, 3)
    val index = 5
    println(array[index])
}

fun productNPE(){
    val name: String? = null
    println(name!!.length)
}

fun roundUpToTwoDecimalPlaces(number: Double): String {
    val multiplied = number * 100
    val ceiled = Math.ceil(multiplied)
    val result = ceiled /100
    val df = DecimalFormat("0.00")
//    return String.format("%.2f", result)
    return df.format(result)
}



interface Visitor {
    fun visit(student: Student)
    fun visit(teacher: Teacher)
}

interface Element {
    fun accept(visitor: Visitor)
}

class Student(var name: String, var grade: Int, var paper: Int) : Element {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}

class Teacher(var name: String, var score: Int, var paper: Int) : Element {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}

class GradeSelection : Visitor {
    override fun visit(student: Student) {
        if (student.grade >= 90) {
            println(student.name + "的分数是" + student.grade + "，荣获了成绩优秀奖。");
        }
    }

    override fun visit(teacher: Teacher) {
        if (teacher.score >= 85) {
            println(teacher.name + "的分数是" + teacher.score + "，荣获了成绩优秀奖。");
        }
    }

}


