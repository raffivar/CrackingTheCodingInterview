package chapter_15_threads_and_locks

class S7FizzBuzz {
    private class FizzBuzzThread(private val n: Int, private val div3: Boolean, private val div5: Boolean) : Thread() {
        override fun run() {
            for (i in 1..n) {
                sleep(100)
                when {
                    div3 && div5 && i % 15 == 0 -> println("$i [FizzBuzz]")
                    div3 && !div5 && i % 3 == 0 -> println("$i [Fizz]")
                    !div3 && div5 && i % 5 == 0 -> println("$i [Buzz]")
                    !div3 && !div5 && i % 3 != 0 && i % 5 != 0 -> println(i)
                }
            }
        }
    }

    fun runTest() {
        val n = 100
        FizzBuzzThread(n, div3 = true, div5 = false).start()
        FizzBuzzThread(n, div3 = false, div5 = true).start()
        FizzBuzzThread(n, div3 = true, div5 = true).start()
        FizzBuzzThread(n, div3 = false, div5 = false).start()
    }
}