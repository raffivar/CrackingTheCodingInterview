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

        fun size(): Int = stack1.size

        fun isEmpty(): Boolean {
            return stack1.isEmpty()
        }

        fun isNotEmpty(): Boolean {
            return stack1.isNotEmpty()
        }
    }

    class MyQueue2<T> {
        private val stackOldest = Stack<T>()
        private val stackNewest = Stack<T>()

        fun push(item: T) {
            stackNewest.push(item)
        }

        fun pop(): T {
            shiftStacks()
            return stackOldest.pop()
        }

        fun peek(): T {
            shiftStacks()
            return stackOldest.peek()
        }

        fun size(): Int = stackOldest.size + stackNewest.size

        fun isEmpty(): Boolean {
            return stackOldest.isEmpty() && stackNewest.isEmpty()
        }

        fun isNotEmpty(): Boolean {
            return !isEmpty()
        }

        private fun shiftStacks() {
            if (stackOldest.isEmpty()) {
                while (stackNewest.isNotEmpty()) {
                    stackOldest.push(stackNewest.pop())
                }
            }
        }
    }


    fun runTest() {
        val myQueue = MyQueue2<Int>()
        for (num in 1..10) {
            myQueue.push(num)
        }
        while (myQueue.isNotEmpty()) {
            println("peeking: ${myQueue.peek()}")
            println("popping: ${myQueue.pop()}")
        }
    }
}