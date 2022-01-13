package chapter_5_recursion

import java.util.*
import kotlin.collections.ArrayList

class S6TowersOfHanoi {
    private fun hanoi(s1: Stack<Int>, s2: Stack<Int>, s3: Stack<Int>): Int {
        printLog(arrayListOf(s1, s2, s3))
        return 0
    }

    private fun printLog(stacks: ArrayList<Stack<Int>>) {
        val sideStack = Stack<Int>()
        for ((i, mainStack) in stacks.withIndex()) {
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

    fun runTest() {
        val functions = arrayListOf(this::hanoi)
        val testCases = arrayListOf(stack1())
        for (function in functions) {
            for (case in testCases) {
                hanoi(case, Stack(), Stack())
            }
        }
    }

    private fun stack1(): Stack<Int> {
        val stack = Stack<Int>()
        val array = arrayListOf(1, 2, 3, 4)
        stack.addAll(array)
        return stack
    }
}