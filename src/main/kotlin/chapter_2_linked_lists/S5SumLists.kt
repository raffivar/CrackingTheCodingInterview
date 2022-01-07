package chapter_2_linked_lists

import chapter_2_linked_lists.helpers.ListBuilder
import chapter_2_linked_lists.helpers.Node
import kotlin.math.log10

class S5SumLists {
    private fun sumLists(node1: Node, node2: Node): Int {
        var result = 0
        var remainder = 0
        var curr1: Node? = node1
        var curr2: Node? = node2
        var multiplier = 1

        while (curr1 != null && curr2 != null) {
            val currResult = curr1.value + curr2.value + remainder
            remainder = (currResult.toFloat() / 10).toInt()
            result += (currResult % 10) * multiplier
            multiplier *= 10
            curr1 = curr1.next
            curr2 = curr2.next
        }

        while (curr1 != null) {
            val currResult = curr1.value + 0 + remainder
            remainder = (currResult.toFloat() / 10).toInt()
            result += (currResult % 10) * multiplier
            multiplier *= 10
            curr1 = curr1.next
        }

        while (curr2 != null) {
            val currResult = 0 + curr2.value + remainder
            remainder = (currResult.toFloat() / 10).toInt()
            result += (currResult % 10) * multiplier
            multiplier *= 10
            curr2 = curr2.next
        }

        return result
    }

    fun runTest() {
        val functions = arrayListOf(this::sumLists)

        val testCases = arrayListOf(
            Pair(ListBuilder.sumList1, ListBuilder.sumList2),
            Pair(ListBuilder.sumList3, ListBuilder.sumList4)
        )

        for (function in functions) {
            for (testCase in testCases) {
                println("------------------------------------------")
                println(ListBuilder.listAsString(testCase.first))
                println("+")
                println(ListBuilder.listAsString(testCase.second))
                println("=")
                println((function(testCase.first, testCase.second)))
            }
        }
    }
}