package chapter_15_threads_and_locks

import kotlin.random.Random

class S5CallInOrder {
    class Foo {
        var isSecondLocked = true
            private set
        var isThirdLock = true
            private set
        
        fun first() {
            println("first")
            isSecondLocked = false
        }

        fun second() {
            println("second")
            isThirdLock = false
        }

        fun third() {
            println("third")
        }
    }

    class ThreadA(private val foo: Foo) : Thread() {
        override fun run() {
            sleep(Random.nextInt(0, 3000).toLong())
            foo.first()
        }
    }

    class ThreadB(private val foo: Foo) : Thread() {
        override fun run() {
            sleep(Random.nextInt(0, 3000).toLong())
            when (foo.isSecondLocked) {
                true -> {
                    println("ThreadB retries")
                    run()
                }
                false -> foo.second()
            }
        }
    }

    class ThreadC(private val foo: Foo) : Thread() {
        override fun run() {
            sleep(Random.nextInt(0, 3000).toLong())
            when (foo.isThirdLock) {
                true -> {
                    println("ThreadC retries")
                    run()
                }
                false -> foo.third()
            }
        }
    }

    private fun runSimulation() {
        val foo = Foo()
        ThreadA(foo).start()
        ThreadB(foo).start()
        ThreadC(foo).start()
    }

    fun runTest() {
        runSimulation()
    }
}