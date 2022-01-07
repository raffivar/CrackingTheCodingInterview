package chapter_3_stacks_and_queues

import java.util.*

class S4QueueViaStacks {
    class MyQueue<T> {
        private var first: T? = null
        private val stack1 = Stack<T>()
        private val stack2 = Stack<T>()

        fun push(item: T) {
            if (stack1.isEmpty()) {
                first = item
            }
            stack1.push(item)
        }

        fun pop(): T {
            while (stack1.isNotEmpty()) {
                stack2.push((stack1.pop()))
            }

            val value = stack2.pop()
            if (stack2.isNotEmpty()) {
                first = stack2.peek()
            }

            while (stack2.isNotEmpty()) {
                stack1.push((stack2.pop()))
            }

            return value
        }

        fun peek(): T {
            return first!!
        }

        fun isEmpty(): Boolean {
            return stack1.isEmpty()
        }

        fun isNotEmpty(): Boolean {
            return stack1.isNotEmpty()
        }
    }

    fun runTest() {
        val myQueue = MyQueue<Int>()
        for (num in 1..10) {
            myQueue.push(num)
        }
        while (myQueue.isNotEmpty()) {
            println("peeking: ${myQueue.peek()}")
            println("popping: ${myQueue.pop()}")
        }
    }
}