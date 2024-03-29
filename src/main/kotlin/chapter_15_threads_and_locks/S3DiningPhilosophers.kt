package chapter_15_threads_and_locks

import Solution
import java.util.concurrent.locks.ReentrantLock
import kotlin.random.Random

class S3DiningPhilosophers: Solution {
    class Chopstick(val name: String) : ReentrantLock()
    class Philosopher(private val pName: String, var left: Chopstick?, var right: Chopstick?) : Thread() {
        var dineTime = 5000L
        var cooldownTime = 500L
        var minWaitTime = 500
        var maxWaitTime = 1500

        override fun run() {
            while (true) {
                //wait a random time to pick up chopsticks
                sleep(Random.nextInt(minWaitTime, maxWaitTime).toLong())

                //attempt to pick up left
                when (!left!!.isLocked) {
                    true -> {
                        left!!.lock()
                        println("$pName picked up left [${left!!.name}]")
                    }
                    false -> {
                        println("$pName could not pick up left [${left!!.name}], trying again in [$cooldownTime] ms")
                        sleep(cooldownTime)
                        continue
                    }
                }

                //attempt to pick up right
                when (!right!!.isLocked) {
                    true -> {
                        right!!.lock()
                        println("$pName picked up right [${right!!.name}]")
                    }
                    false -> {
                        println("$pName could not pick up right [${right!!.name}], freeing left [${left!!.name}] + trying again in [$cooldownTime] ms")
                        freeLeft()
                        sleep(cooldownTime)
                        continue
                    }
                }

                //dine
                println("$pName started dining")
                sleep(dineTime)
                freeLeft()
                freeRight()
                println("$pName stopped dining")
            }
        }

        private fun freeLeft() {
            left!!.let {
                if (it.isHeldByCurrentThread) {
                    it.unlock()
                    println("$pName put down left [${it.name}]")
                }
            }
        }

        private fun freeRight() {
            right!!.let {
                if (it.isHeldByCurrentThread) {
                    it.unlock()
                    println("$pName put down right [${it.name}]")
                }
            }
        }
    }

    class DiningTable(n: Int) {
        private val philosophers = arrayListOf<Philosopher>()

        init {
            for (i in 0 until n) {
                val philosopher = when (i) {
                    0 -> Philosopher("Philosopher #$i", null, Chopstick("Chopstick #1"))
                    n - 1 -> Philosopher("Philosopher #$i", philosophers[i - 1].right, Chopstick("Chopstick #0"))
                    else -> Philosopher("Philosopher #$i", philosophers[i - 1].right, Chopstick("Chopstick #${i + 1}"))
                }
                philosophers.add(philosopher)
            }
            philosophers[0].left = philosophers.last().right
        }

        fun startDining() {
            for (philosopher in philosophers) {
                philosopher.start()
            }
        }
    }

    override fun runTest() {
        val table = DiningTable(4)
        table.startDining()
    }
}