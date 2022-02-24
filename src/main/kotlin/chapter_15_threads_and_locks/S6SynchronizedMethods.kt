package chapter_15_threads_and_locks

import Solution

class S6SynchronizedMethods : Solution {
    @Synchronized
    private fun printTableA() {
        val n = 10
        for (i in 1..5) {
            println("[A] ${n * i}")
            try {
                Thread.sleep(400)
            } catch (e: Exception) {
                println(e)
            }
        }
    }

    private fun printTableB() {
        val n = 10
        for (i in 1..5) {
            println("[B] ${n * i}")
            try {
                Thread.sleep(400)
            } catch (e: Exception) {
                println(e)
            }
        }
    }

    private fun runATwice() {
        Thread { printTableA() }.start()
        Thread { printTableA() }.start()
    }

    private fun runAAndB() {
        Thread { printTableA() }.start()
        Thread { printTableB() }.start()
    }

    override fun runTest() {
        /**
         *
         * Given a synchronized method A, and a normal method B,The answer to the question is:
         * You cannot run methodA twice from two different threads at the same time
         * You can, however run methodA and methodB from two different threads at the same time
         * Uncomment one of the lines below to test
         *
         */

        //runATwice()
        //runAAndB()
    }
}