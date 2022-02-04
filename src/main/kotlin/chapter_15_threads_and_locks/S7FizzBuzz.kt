package chapter_15_threads_and_locks

class S7FizzBuzz {
    private class FizzBuzzThread(private val n: Int, private val d: Int) : Thread() {
        override fun run() {
            for (i in 1..n) {
                sleep(100)
                if (i % d == 0) {
                    println("$i is divisible by $d")
                }
            }
        }
    }

    fun runTest() {
        val n = 100
        FizzBuzzThread(n, 3).start()
        FizzBuzzThread(n, 5).start()
        FizzBuzzThread(n, 15).start()
    }
}