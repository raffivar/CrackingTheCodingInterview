package chapter_15_threads_and_locks.examples

import java.util.concurrent.locks.ReentrantLock

class ATM {
    fun runExample() {
        val atm = LockedATM()
        atm.withdraw(100)
        atm.deposit(50)
    }

    class LockedATM {
        private val lock = ReentrantLock()
        private var balance = 100

        fun withdraw(value: Int) {
            lock.lock()
            var temp = balance
            try {
                Thread.sleep(100)
                temp -= value
                balance = temp
            } catch (e: InterruptedException) {
            }
            lock.unlock()
            println("New balance: $balance")
        }

        fun deposit(value: Int) {
            lock.lock()
            var temp = balance
            try {
                Thread.sleep(100)
                temp += value
                Thread.sleep(300)
                balance = temp
            } catch (e: InterruptedException) {
            }
            lock.unlock()
            println("New balance: $balance")
        }
    }
}