package chapter_2_linked_lists

import chapter_2_linked_lists.helpers.ListBuilder
import chapter_2_linked_lists.helpers.Node

class S3DeleteMiddleNode {
    private fun removeDuplicates(node: Node) {
        var current = node
        while (current.next?.next != null) {
            current.value = current.next!!.value
            current = current.next!!
        }
        current.value = current.next!!.value
        current.next = null
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
        val functions = arrayListOf(this::removeDuplicates)

        val testCases = arrayListOf(
            ListBuilder.list1,
            ListBuilder.list2,
            ListBuilder.list3,
        )

        for (function in functions) {
            for (testCase in testCases) {
                println("------------------------------------------")
                println("B: ${ListBuilder.listAsString(testCase)}")
                function(getMiddleNode(testCase))
                println("A: ${ListBuilder.listAsString(testCase)}")
            }
        }
    }

}