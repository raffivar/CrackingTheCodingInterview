package chapter_2_linked_lists

import chapter_2_linked_lists.helpers.LinkedListUtil
import chapter_2_linked_lists.helpers.Node
import kotlin.math.abs

class S7Intersection {
    private fun findIntersection(node1: Node?, node2: Node?): Node? {
        var size1 = 0
        var current1 = node1
        while (current1 != null) {
            size1++
            current1 = current1.next
        }

        var size2 = 0
        var current2 = node2
        while (current2 != null) {
            size2++
            current2 = current2.next
        }

        val offset = abs(size1 - size2)

        if (size2 > size1) {
            current1 = node1
            current2 = node2
            for (i in 0 until offset) {
                current2 = current2!!.next
            }
        }

        if (size1 > size2) {
            current2 = node2
            current1 = node1
            for (i in 0 until offset) {
                current1 = current1!!.next
            }
        }

        while (current1 != null && current2 != null) {
            if (current1 == current2) {
                return current1
            }
            current1 = current1.next
            current2 = current2.next
        }

        return null
    }

    fun runTest() {
        val functions = arrayListOf(this::findIntersection)
        val intersection = Node(10, Node(11, (Node(12, null))))
        val list1 = Node(1, Node(2, Node(3, intersection)))
        val list2 = Node(4, Node(5, Node(6, Node(7, Node(8, intersection)))))

        val testCases = arrayListOf(
            Pair(list1, list2),
        )

        for (function in functions) {
            for (testCase in testCases) {
                println(LinkedListUtil.listAsString(intersection))
                println(LinkedListUtil.listAsString(testCase.first))
                println(LinkedListUtil.listAsString(testCase.second))
                println("INTERSECTION:")
                println(LinkedListUtil.listAsString(function(testCase.first, testCase.second)))
            }
        }
    }
}