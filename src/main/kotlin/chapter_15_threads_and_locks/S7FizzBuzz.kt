package chapter_15_threads_and_locks

class S7FizzBuzz {
    private class FizzBuzzThread(
        private val n: Int,
        private val div3: Boolean,
        private val div5: Boolean,
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
                if (i >= n) {
                    return
                }
                synchronized(lock) {
                    if ((i % 3 == 0) == div3 && (i % 5 == 0) == div5) {
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
        FizzBuzzThread(n, div3 = true, div5 = true, "FizzBuzz").start()
        FizzBuzzThread(n, div3 = true, div5 = false, "Fizz").start()
        FizzBuzzThread(n, div3 = false, div5 = true, "Buzz").start()
        FizzBuzzThread(n, div3 = false, div5 = false, null).start()
    }
}