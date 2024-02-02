import kotlinx.coroutines.*


suspend fun dofirst(): Int {
    delay(1000)
    return 100
}

suspend fun doseconde(): Int {
    delay(1000)
    return 21
}

fun Job.log() {
    log(
        """
        isActive = $isActive
        icCancelled = $isCancelled
        isCompleted = $isCompleted
    """.trimIndent()
    )
}

fun log(any: Any?) {
    println(
        """
        =========================
        $any
        Thread:${Thread.currentThread().name}
        =========================
    """.trimIndent()
    )
}

fun main() = runBlocking {
    for(i in 1..3) println(i)
}