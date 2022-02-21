package chapter_2_linked_lists

import chapter_2_linked_lists.util.LinkedListUtil
import chapter_2_linked_lists.util.Node
import java.util.*

class S6IsPalindrome { //Another approach: reverse and compare
    private fun isPalindrome(node: Node?): Boolean {
        val length = LinkedListUtil.length(node)
        var start = node
        for (i in 0..length / 2) {
            var end = start
            for (j in i until length - i - 1) {
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
        val length = LinkedListUtil.length(node)
        var current = node
        val stack = Stack<Int>()
        for (i in 0..length / 2) {
            stack.push(current!!.value)
            current = current.next
        }
        if (length % 2 == 1) {
            current = current!!.next
        }
        while (current != null) {
            if (current.value != stack.pop()) {
                return false
            }
        }
        return true
    }

    private class Result(
        var node: Node?,
        var result: Boolean
    )

    private fun isPalindrome3(node: Node?): Boolean {
        val length = LinkedListUtil.length(node)
        return isPalindromeRecurse(node, length).result
    }

    private fun isPalindromeRecurse(head: Node?, length: Int): Result {
        when {
            head == null || length <= 0 -> return Result(head, true)
            length == 1 -> return Result(head.next, true)
        }
        val result = isPalindromeRecurse(head?.next, length - 2)
        if (result.node == null || !result.result) {
            return result
        }
        result.result = (head?.value == result.node?.value)
        result.node = result.node?.next
        return result
    }


    fun runTest() {
        val functions = arrayListOf(this::isPalindrome, this::isPalindrome2, this::isPalindrome3)

        val testCases = arrayListOf(
            LinkedListUtil.list1,
            LinkedListUtil.list2,
            LinkedListUtil.list3,
            LinkedListUtil.list6,
            LinkedListUtil.list7,
        )

        for (function in functions) {
            println("--------------------------------------------------------------------------")
            println("${function.name}:")
            for (testCase in testCases) {
                println("${LinkedListUtil.listAsString(testCase)} -> ${isPalindrome(testCase)}")
            }
        }
    }
}