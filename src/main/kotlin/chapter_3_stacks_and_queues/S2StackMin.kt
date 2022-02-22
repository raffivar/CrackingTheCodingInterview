package chapter_3_stacks_and_queues

import Solution
import java.util.*

class S2StackMin : Solution {
    class StackWithMin : Stack<Int>() {
        private val minStack = Stack<Int>()

        fun min(): Int {
            return when (minStack.isEmpty()) {
                true -> Int.MAX_VALUE
                false -> minStack.peek()
            }
        }

        override fun push(num: Int): Int {
            if (num <= min()) {
                minStack.push(num)
            }
            return super.push(num)
        }

        override fun pop(): Int {
            val value = super.pop()
            if (value == min()) {
                minStack.pop()
            }
            return value
        }
    }

    override fun runTest() {
        val testCases = arrayListOf(arrayListOf(5, 4, 3, 2, 1))
        for (case in testCases) {
            val stack = StackWithMin()
            println("PUSHING:")
            for (num in case) {
                println("Pushed [${stack.push(num)}], current min: [${stack.min()}]")
            }
            println("POPPING:")
            while (stack.isNotEmpty()) {
                println("Current min: [${stack.min()}], popped: [${stack.pop()}]")
            }
        }
    }
}