package chapter_15_threads_and_locks

import java.util.function.Predicate

class S7FizzBuzz {
    private class FizzBuzzThread(
        private val n: Int,
        private val validate: Predicate<Int>,
        private val toPrint: String?
    ) : Thread() {
        companion object {
            @JvmStatic
            var lock = Object()

            @JvmStatic
            var i = 1
        }

        override fun run() {
            while (true) {
                synchronized(lock) {
                    if (i > n) {
                        return
                    }
                    if (validate.test(i)) {
                        when (toPrint) {
                            null -> println(i)
                            else -> println(toPrint)
                        }
                        i++
                    }
                }
            }
        }
    }

    fun runTest() {
        val n = 100
        FizzBuzzThread(n, { i: Int -> i % 3 == 0 && i % 5 == 0 }, "FizzBuzz").start()
        FizzBuzzThread(n, { i: Int -> i % 3 == 0 && i % 5 != 0 }, "Fizz").start()
        FizzBuzzThread(n, { i: Int -> i % 3 != 0 && i % 5 == 0 }, "Buzz").start()
        FizzBuzzThread(n, { i: Int -> i % 3 != 0 && i % 5 != 0 }, null).start()
    }
}