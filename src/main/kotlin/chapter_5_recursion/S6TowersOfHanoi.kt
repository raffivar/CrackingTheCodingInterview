package chapter_5_recursion

import java.util.*
import kotlin.collections.ArrayList

class S6TowersOfHanoi {
    private fun hanoi(t1: Tower, t2: Tower, t3: Tower): Int {
        printLog(arrayListOf(t1, t2, t3))
        return 0
    }

    private fun printLog(towers: ArrayList<Tower>) {
        val sideStack = Stack<Int>()
        for ((i, t) in towers.withIndex()) {
            val mainStack = t.disks
            while (mainStack.isNotEmpty()) {
                sideStack.push((mainStack.pop()))
            }
            println("s${i + 1}:\n----")
            while (sideStack.isNotEmpty()) {
                val value = sideStack.pop()
                println(value)
                mainStack.push(value)
            }
            println()
        }
    }

    class Tower(private val i: Int) {
        constructor() : this(0)
        val disks = Stack<Int>()
        init {
            for (disk in i downTo 1) {
                disks.add(disk)
            }
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