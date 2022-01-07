package chapter_2_linked_lists

import java.util.*
import kotlin.collections.HashSet


class S1RemoveDuplicates {
    private fun removeDuplicates(list: LinkedList<Int>) {
        val set = HashSet<Int>()
        var i = 0
        while (i < list.size) {
            if (!set.contains(list[i])) {
                set.add(list[i])
                i++
            } else {
                list.removeAt(i)
            }
        }
    }

    fun runTest() {
        val functions = arrayListOf(this::removeDuplicates)
        val testCases = arrayListOf(
            LinkedList(listOf(1, 2, 3, 4, 2, 5, 6, 7, 8, 5))
        )
        for (function in functions) {
            println("------------------------------------------")
            for (testCase in testCases) {
                println("B: $testCase")
                function(testCase)
                println("A: $testCase")
            }
        }
    }
}