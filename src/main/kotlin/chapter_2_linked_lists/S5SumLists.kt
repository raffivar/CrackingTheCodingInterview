package chapter_2_linked_lists

import chapter_2_linked_lists.util.LinkedListUtil
import chapter_2_linked_lists.util.Node
import kotlin.math.abs
import kotlin.math.log10
import kotlin.math.pow

class S5SumLists {
    private fun Int.length() = when (this) {
        0 -> 0
        else -> log10(abs(toDouble())).toInt() + 1
    }

    private fun sumLists(node1: Node, node2: Node): Int {
        var result = 0
        var remainder = 0
        var curr1: Node? = node1
        var curr2: Node? = node2

        while (curr1 != null && curr2 != null) {
            val currResult = curr1.value + curr2.value + remainder
            remainder = (currResult.toFloat() / 10).toInt()
            result += (currResult % 10) * 10.0.pow(result.length().toDouble()).toInt()
            curr1 = curr1.next
            curr2 = curr2.next
        }

        while (curr1 != null) {
            val currResult = curr1.value + 0 + remainder
            remainder = (currResult.toFloat() / 10).toInt()
            result += (currResult % 10) * 10.0.pow(result.length().toDouble()).toInt()
            curr1 = curr1.next
        }

        while (curr2 != null) {
            val currResult = 0 + curr2.value + remainder
            remainder = (currResult.toFloat() / 10).toInt()
            result += (currResult % 10) * 10.0.pow(result.length().toDouble()).toInt()
            curr2 = curr2.next
        }

        return result
    }


    private fun sumListsRec(l1: Node?, l2: Node?): Node? {
        return sumListsRec(l1, l2, 0)
    }

    private fun sumListsRec(l1: Node?, l2: Node?, carry: Int): Node? {
        if (l1 == null && l2 == null && carry == 0) {
            return null
        }
        val result = Node(0, null)
        var value = carry
        if (l1 != null) {
            value += l1.value
        }
        if (l2 != null) {
            value += l2.value
        }
        result.value = value % 10
        if (l1 != null || l2 != null) {
            val more = sumListsRec(l1?.next, l2?.next, if (value >= 10) 1 else 0)
            result.next = more
        }
        return result
    }

    fun runTest() {
        val functions = arrayListOf(this::sumLists, this::sumListsRec)

        val testCases = arrayListOf(
            Pair(LinkedListUtil.sumList1, LinkedListUtil.sumList2),
            Pair(LinkedListUtil.sumList3, LinkedListUtil.sumList4)
        )

        for (function in functions) {
            for (testCase in testCases) {
                println("------------------------------------------")
                println(LinkedListUtil.listAsString(testCase.first))
                println("+")
                println(LinkedListUtil.listAsString(testCase.second))
                println("=")
                when (val result = function(testCase.first, testCase.second)) {
                    is Int -> println(result)
                    is Node -> println(LinkedListUtil.listAsString(result))
                }
            }
        }
    }
}