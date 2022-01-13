package chapter_5_recursion

import java.util.*
import kotlin.collections.ArrayList

class S6TowersOfHanoi {
    private fun hanoi(t1: Tower, t2: Tower, t3: Tower) {
        t1.moveDisks(t1.i, t3, t2)
    }

    class Tower(val i: Int) {
        constructor() : this(0)

        private val disks = Stack<Int>()

        init {
            for (disk in i downTo 1) {
                disks.add(disk)
            }
        }

        private fun add(disk: Int) {
            when (disks.isNotEmpty() && disks.peek() <= disk) {
                true -> println("Error placing disk [$disk]")
                false -> disks.push(disk)
            }
        }

        private fun moveTopTo(t: Tower) {
            val top = disks.pop()
            t.add(top)
        }

        fun moveDisks(n: Int, dest: Tower, buffer: Tower) {
            printLog(arrayListOf(this, buffer, dest))
            if (n > 0) {
                moveDisks(n - 1, buffer, dest)
                moveTopTo(dest)
                buffer.moveDisks(n - 1, dest, this)
            }
        }

        private fun printLog(towers: ArrayList<Tower>) {
            val sideStack = Stack<Int>()
            for ((i, t) in towers.withIndex()) {
                println("s${i + 1}:\n----")
                while (t.disks.isNotEmpty()) {
                    val value = t.disks.pop()
                    println(value)
                    sideStack.push(value)
                }
                println()
                while (sideStack.isNotEmpty()) {
                    t.disks.push(sideStack.pop())
                }
            }
            println("====================================")
        }
    }

    fun runTest() {
        val functions = arrayListOf(this::hanoi)
        val testCases = arrayListOf(Tower(4))
        for (function in functions) {
            for (case in testCases) {
                hanoi(case, Tower(), Tower())
            }
        }
    }
}