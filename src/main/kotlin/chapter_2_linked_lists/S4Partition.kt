package chapter_2_linked_lists

import chapter_2_linked_lists.util.LinkedListUtil
import chapter_2_linked_lists.util.Node

class S4Partition {
    private fun partition(node: Node, x: Int): Node? {
        var head1: Node? = null
        var current1: Node? = null
        var head2: Node? = null
        var current2: Node? = null
        var current = node
        while (current.next != null) {
            if (current.value < x) {
                if (current1 == null) {
                    head1 = current
                    current1 = current
                } else {
                    current1.next = current
                    current1 = current1.next
                }
            } else {
                if (current2 == null) {
                    head2 = current
                    current2 = current
                } else {
                    current2.next = current
                    current2 = current2.next
                }
            }

            current = current.next!!
        }

        if (current2 != null) {
            current2.next = null
        }

        return if (current1 == null) {
            head2
        } else {
            current1.next = head2
            head1
        }
    }

    fun runTest() {
        val functions = arrayListOf(this::partition)

        val testCases = arrayListOf(
            LinkedListUtil.list4,
            LinkedListUtil.list5
        )

        for (function in functions) {
            for (testCase in testCases) {
                println("------------------------------------------")
                println("B: ${LinkedListUtil.listAsString(testCase)}")
                println("A: ${LinkedListUtil.listAsString(function(testCase, 5))}")
            }
        }
    }

}