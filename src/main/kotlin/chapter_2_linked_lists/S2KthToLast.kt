package chapter_2_linked_lists

import Solution
import chapter_2_linked_lists.util.LinkedListUtil
import chapter_2_linked_lists.util.Node

class S2KthToLast : Solution {
    private fun findKthToLast(head: Node?, k: Int): Node? {
        var p1 = head
        var p2 = head

        for (i in 0 until k) {
            if (p2 == null) {
                return null
            }
            p2 = p2.next
        }

        while (p2 != null) {
            p1 = p1!!.next
            p2 = p2.next
        }

        return p1
    }

    override fun runTest() {
        val functions = arrayListOf(this::findKthToLast)
        val testCases = arrayListOf(
            Pair(LinkedListUtil.list1, 3),
            Pair(LinkedListUtil.list1, 5),
            Pair(LinkedListUtil.list1, -2),
            Pair(LinkedListUtil.list1, 12)
        )
        for (function in functions) {
            for (case in testCases) {
                val result = function(case.first, case.second)?.value
                println("${function.name}(${LinkedListUtil.listAsString(case.first)}, ${case.second}): $result")
            }
        }
    }
}