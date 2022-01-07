package chapter_2_linked_lists

import chapter_2_linked_lists.helpers.ListBuilder
import chapter_2_linked_lists.helpers.Node

class S3DeleteMiddleNode {
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

    fun runTest() {
        val functions = arrayListOf(this::deleteMiddleNode1, this::deleteMiddleNode2)

        for (function in functions) {
            val testCases = arrayListOf(
                Node(1, Node(2, Node(3, Node(4, Node(5, Node(6, Node(7, null))))))),
                Node(1, Node(2, Node(3, Node(4, null)))),
                Node(1, Node(2, null))
            )
            for (testCase in testCases) {
                println("------------------------------------------")
                println("B: ${ListBuilder.listAsString(testCase)}")
                function(getMiddleNode(testCase))
                println("A: ${ListBuilder.listAsString(testCase)}")
            }
        }
    }

}