package chapter_13_java

import java.lang.Exception

class S2ReturnFromFinally {
    /**
     * S2 - Return from Finally:
     * Q: In Java, does the finally block get executed if we insert a return statement inside the try block of a try-catch-finally?
     * A: Yes
     */

    private fun example(throwException: Boolean) {
        try {
            println("This is the try block")
            if (throwException) {
                throw Exception()
            }
            return
        } catch (e: Exception) {
            println("this is the catch block")
            return
        } finally {
            println("this is the finally block")
        }
    }

    fun runTest() {
        example(false)
        println("-------------------------------")
        example(true)
    }
}