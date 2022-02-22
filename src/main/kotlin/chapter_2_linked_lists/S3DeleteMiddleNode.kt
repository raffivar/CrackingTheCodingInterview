package chapter_2_linked_lists

import Solution
import chapter_2_linked_lists.util.LinkedListUtil
import chapter_2_linked_lists.util.Node

class S3DeleteMiddleNode : Solution {
    private fun deleteMiddleNode1(node: Node) {
        var current = node
        while (current.next?.next != null) {
            current.value = current.next!!.value
            current = current.next!!
        }
        current.value = current.next!!.value
        current.next = null
    }

    private fun deleteMiddleNode2(node: Node?) {
        if (node?.next == null) {
            return
        }
        node.value = node.next!!.value
        node.next = node.next!!.next
    }

    private fun getMiddleNode(head: Node): Node {
        var current = head
        var size = 0
        while (current.next != null) {
            current = current.next!!
            size++
        }
        current = head
        for (i in 0 until size / 2) {
            current = current.next!!
        }
        return current
    }

    override fun runTest() {
        val functions = arrayListOf(this::deleteMiddleNode1, this::deleteMiddleNode2)
        for (function in functions) {
            println("Using ${function.name}:")
            val testCases = arrayListOf(
                Node(1, Node(2, Node(3, Node(4, Node(5, Node(6, Node(7, null))))))),
                Node(1, Node(2, Node(3, Node(4, null)))),
                Node(1, Node(2, null))
            )
            for (case in testCases) {
                println("Before:\n${LinkedListUtil.listAsString(case)}")
                function(getMiddleNode(case))
                println("After:\n${LinkedListUtil.listAsString(case)}\n")
            }
            println()
        }
    }
}