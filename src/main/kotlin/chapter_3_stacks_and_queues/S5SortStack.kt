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
        val stack = Stack<Int>()
        stack.push(5)
        stack.push(8)
        stack.push(1)
        stack.push(7)
        stack.push(3)
        stack.push(11)
        stack.push(2)
        sortStack(stack)
    }
}