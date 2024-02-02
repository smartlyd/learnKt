package utils


object LogUtils {
    const val DEFAULT_TAG = "LogUtils"
    fun d(msg: String, tag: String = DEFAULT_TAG) {
        println("$tag >>> ${msg}")
    }
}