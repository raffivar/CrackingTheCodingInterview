package chapter_2_linked_lists

import chapter_2_linked_lists.util.LinkedListUtil
import chapter_2_linked_lists.util.Node
import java.util.*

class S6IsPalindrome {
    private fun isPalindrome(head: Node?): Boolean {
        val length = LinkedListUtil.length(head)
        var start = head
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

    private fun isPalindrome1(head: Node?): Boolean {
        val reversed = reverseAndClone(head)
        println("Reverse and compare:\n${LinkedListUtil.listAsString(reversed)}")
        return isEqual(head, reversed)
    }

    private fun reverseAndClone(originalHead: Node?): Node? {
        var curr = originalHead
        var head: Node? = null
        while (curr != null) {
            head = Node(curr.value, head)
            curr = curr.next
        }
        return head
    }

    private fun isEqual(head1: Node?, head2: Node?): Boolean {
        var n1 = head1
        var n2 = head2
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                return false
            }
            n1 = n1.next
            n2 = n2.next
        }
        return n1 == null && n2 == null
    }

    private fun isPalindrome2(head: Node?): Boolean {
        val length = LinkedListUtil.length(head)
        var current = head
        val stack = Stack<Int>()
        for (i in 0..length / 2) {
            stack.push(current!!.value)
            current = current.next
        }
        if (length % 2 == 1) {
            current = current?.next
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

    private fun isPalindrome3(head: Node?): Boolean {
        val length = LinkedListUtil.length(head)
        return isPalindromeRecurse(head, length).result
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
        val functions = arrayListOf(this::isPalindrome, this::isPalindrome1, this::isPalindrome2, this::isPalindrome3)

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
                println("${LinkedListUtil.listAsString(testCase)} -> ${function(testCase)}")
            }
        }
    }
}