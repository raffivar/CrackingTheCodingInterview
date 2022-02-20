package chapter_2_linked_lists

import chapter_2_linked_lists.helpers.LinkedListUtil
import chapter_2_linked_lists.helpers.Node
import java.util.*

class S6IsPalindrome {
    //Another approach: reverse and compare
    //Another approach: recursion

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

    private fun isPalindrome2(node: Node?): Boolean {
        var size = 0
        var current = node

        // Size can be found in a more efficient way
        // if we take a "slow" pointer and a "fast" pointer.
        // p1 runs 1 step, p2 runs 2 steps,
        // we are in the middle of the list when p2 hits the end
        // This way we don not have to run over the list twice.
        while (current != null) {
            size++
            current = current.next
        }

        current = node
        val stack = Stack<Int>()

        for (i in 0..size / 2) {
            stack.push(current!!.value)
            current = current.next
        }

        if (size % 2 == 1) {
            current = current!!.next
        }

        while (current != null) {
            if (current.value != stack.pop()) {
                return false
            }
        }

        return true
    }

    fun runTest() {
        val functions = arrayListOf(this::isPalindrome, this::isPalindrome2)

        val testCases = arrayListOf(
            LinkedListUtil.list1,
            LinkedListUtil.list2,
            LinkedListUtil.list3,
            LinkedListUtil.list6,
            LinkedListUtil.list7,
        )

        for (function in functions) {
            println("--------------------------------------------------------------------------")
            for (testCase in testCases) {
                println("${LinkedListUtil.listAsString(testCase)} -> ${isPalindrome(testCase)}")
            }
        }
    }
}