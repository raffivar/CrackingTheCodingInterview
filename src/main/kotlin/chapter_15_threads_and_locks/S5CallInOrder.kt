package chapter_15_threads_and_locks

import Solution
import java.util.concurrent.Semaphore

class S5CallInOrder : Solution {
    class Foo {
        private val sem1 = Semaphore(1)
        private val sem2 = Semaphore(1)

        init {
            sem1.acquire()
            sem2.acquire()
        }

        fun first() {
            println("first")
            sem1.release()
        }

        fun second() {
            sem1.acquire()
            sem1.release()
            println("second")
            sem2.release()
        }

        fun third() {
            sem2.acquire()
            sem2.release()
            println("third")
        }
    }

    class ThreadA(private val foo: Foo) : Thread() {
        override fun run() {
            sleep(3000)
            foo.first()
        }
    }

    class ThreadB(private val foo: Foo) : Thread() {
        override fun run() {
            sleep(2000)
            foo.second()
        }
    }

    class ThreadC(private val foo: Foo) : Thread() {
        override fun run() {
            sleep(1000)
            foo.third()
        }
    }

    override fun runTest() {
        val foo = Foo()
        ThreadA(foo).start()
        ThreadB(foo).start()
        ThreadC(foo).start()
    }
}