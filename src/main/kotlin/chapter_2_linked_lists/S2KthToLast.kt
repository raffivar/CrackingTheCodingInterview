package chapter_2_linked_lists

import java.util.*

class S2KthToLast {
    private fun findKthToLast(list: LinkedList<Int>, k: Int): Int{
        return list[list.size - k]
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
}