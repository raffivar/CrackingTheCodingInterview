package chapter_3_stacks_and_queues

import java.util.*

private const val THRESHOLD = 5

class S3StackOfPlates {
    class StackNode<T>(val stack: Stack<T>, val next: StackNode<T>?)

    class MyStack<T> {
        var stackNode = StackNode(Stack<T>(), null)

        fun push(item: T) {
            if (stackNode.stack.size == THRESHOLD) {
                stackNode = StackNode(Stack<T>(), stackNode)
            }
            stackNode.stack.push(item)
        }

        fun pop(): T {
            if (stackNode.stack.isEmpty() && stackNode.next != null) {
                stackNode = stackNode.next!!
                println("MOVING STACK")
            }

            return stackNode.stack.pop()
        }

        fun popAt(i: Int): T {
            var current = stackNode
            for (j in 0 until i) {
                current = current.next!!
            }
            return current.stack.pop()
        }

        fun peek(): T {
            return stackNode.stack.peek()
        }

        fun isEmpty(): Boolean {
            return stackNode.stack.isEmpty() && stackNode.next == null
        }
    }

    fun runTest() {
        val myStack = MyStack<Int>()
        for (i in 15 downTo 1) {
            myStack.push(i)
        }
        println(myStack.popAt(0))
        println(myStack.popAt(1))
        println(myStack.popAt(2))

        println("EMPTYING STACK")
        while (!myStack.isEmpty()) {
            println(myStack.pop())
        }
    }
}