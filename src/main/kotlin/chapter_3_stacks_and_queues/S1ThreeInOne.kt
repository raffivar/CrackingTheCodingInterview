package chapter_3_stacks_and_queues

import Solution

class S1ThreeInOne : Solution {
    /**
     * This is the solution for fixed sized stack.
     * There is another solution that supports dynamic sizes.
     */

    class FixedMultiStack(private val stackSize: Int) {
        private val numOfStacks = 3
        private val values = IntArray(numOfStacks * stackSize)
        private val sizes = IntArray(numOfStacks)

        fun push(stackNum: Int, value: Int) {
            if (isFull(stackNum)) {
                throw Exception("Stack is full")
            }
            sizes[stackNum]++
            values[topIndex(stackNum)] = value
        }

        fun pop(stackNum: Int): Int {
            if (isEmpty(stackNum)) {
                throw Exception("Stack is empty")
            }
            val topIndex = topIndex(stackNum)
            val value = values[topIndex]
            values[topIndex] = 0
            sizes[stackNum]--
            return value
        }

        fun peek(stackNum: Int): Int {
            if (isEmpty(stackNum)) {
                throw Exception("Stack is empty")
            }
            return values[topIndex(stackNum)]
        }

        fun isEmpty(stackNum: Int): Boolean {
            return sizes[stackNum] == 0
        }

        private fun isFull(stackNum: Int): Boolean {
            return sizes[stackNum] == stackSize
        }

        private fun topIndex(stackNum: Int): Int {
            val offset = stackNum * stackSize
            val size = sizes[stackNum]
            return offset + size - 1
        }
    }

    override fun runTest() {
        val testCases = arrayListOf(
            arrayListOf(7, 8, 9),
            arrayListOf(4, 5, 6),
            arrayListOf(1, 2, 3)
        )
        val multiStack = FixedMultiStack(5)
        for ((i, case) in testCases.withIndex()) {
            for (num in case) {
                multiStack.push(i, num)
            }
        }
        for (i in 0..testCases.lastIndex) {
            println("stack #$i:")
            while (!multiStack.isEmpty(i)) {
                println("Peek: [${multiStack.peek(i)}], Pop: [${multiStack.pop(i)}]")
            }
        }
    }
}