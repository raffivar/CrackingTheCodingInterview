package chapter_2_linked_lists

import chapter_2_linked_lists.helpers.ListBuilder
import chapter_2_linked_lists.helpers.Node

class S6IsPalindrome {
    private fun isPalindrome(node: Node?): Boolean {
        var size = 0
        var current = node

        while (current != null) {
            size++
            current = current.next
        }

        var start = node
        for (i in 0..size / 2) {
            var end = start
            for (j in i until size - i - 1) {
                end = end!!.next
            }
            if (start!!.value != end!!.value) {
                return false
            }
            start = start.next
        }

        return true
    }

    fun runTest() {
        val functions = arrayListOf(this::isPalindrome)

        val testCases = arrayListOf(
            ListBuilder.list1,
            ListBuilder.list2,
            ListBuilder.list3,
            ListBuilder.list6,
            ListBuilder.list7,
        )

        for (function in functions) {
            for (testCase in testCases) {
                println("${ListBuilder.listAsString(testCase)} -> ${isPalindrome(testCase)}")
            }
        }
    }
}