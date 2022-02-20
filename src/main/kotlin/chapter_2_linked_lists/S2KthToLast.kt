package chapter_2_linked_lists

import chapter_2_linked_lists.util.LinkedListUtil
import chapter_2_linked_lists.util.Node
import java.util.*

class S2KthToLast {
    private fun findKthToLast(list: LinkedList<Int>, k: Int): Int{
        return list[list.size - k]
    }

    private fun findKthToLast2(head: Node?, k: Int): Node?{
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

    fun runTest() {
        val functions = arrayListOf(this::findKthToLast)
        val testCases = arrayListOf(
            LinkedList(listOf(1, 2, 3, 4, 2, 5, 6, 7, 8, 5))
        )

        for (function in functions) {
            println("------------------------------------------")
            for (testCase in testCases) {
                println("${function.name}($testCase, 3): ${function(testCase, 3)}")
            }
        }
    }

    fun runTest2() {
        val functions = arrayListOf(this::findKthToLast2)
        val testCases = arrayListOf(
            LinkedListUtil.list1
        )

        for (function in functions) {
            println("------------------------------------------")
            for (testCase in testCases) {
                println("${function.name}(${LinkedListUtil.listAsString(testCase)}, 3: ${function(testCase, 3)!!.value}")
            }
        }
    }
}