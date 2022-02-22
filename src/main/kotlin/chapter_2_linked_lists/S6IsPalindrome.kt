package chapter_2_linked_lists

import Solution
import chapter_2_linked_lists.util.LinkedListUtil
import chapter_2_linked_lists.util.Node
import java.util.*

class S6IsPalindrome : Solution {
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
        val stack = Stack<Int>()
        var fast = head
        var slow = head
        while (fast?.next != null) {
            stack.push(slow!!.value)
            slow = slow.next
            fast = fast.next!!.next
        }
        if (fast != null) {
            slow = slow!!.next
        }
        while (slow != null) {
            if (slow.value != stack.pop()) {
                return false
            }
            slow = slow.next
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


    override fun runTest() {
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
            for (case in testCases) {
                println("${LinkedListUtil.listAsString(case)} -> ${function(case)}")
            }
        }
    }
}