package chapter_3_stacks_and_queues

import Solution
import java.util.*

class S5SortStack : Solution {
    private fun sortStack(stack: Stack<Int>) {
        val temp = Stack<Int>()
        var count = 0

        while (stack.isNotEmpty() && count < stack.size) {
            var min = stack.pop()

            while (stack.isNotEmpty()) {
                val e = stack.pop()
                if (e < min) {
                    temp.push(min)
                    min = e
                } else {
                    temp.push(e)
                }
            }

            stack.push(min)

            while (temp.isNotEmpty()) {
                stack.push((temp.pop()))
            }

            count++
        }
    }

    override fun runTest() {
        val testCases = arrayListOf(arrayListOf(5, 8, 1, 7, 3, 11, 2))
        for (case in testCases) {
            val stack = Stack<Int>()
            println("[PUSHING]:")
            for (num in case) {
                println("Pushed: [${stack.push(num)}]")
            }
            println("[SORTING]")
            sortStack(stack)
            println("[POPPING]:")
            while (stack.isNotEmpty()) {
                println("Popped: [${stack.pop()}]")
            }
        }
    }
}