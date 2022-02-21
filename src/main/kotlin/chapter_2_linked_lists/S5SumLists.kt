package chapter_2_linked_lists

import chapter_2_linked_lists.util.LinkedListUtil
import chapter_2_linked_lists.util.Node

class S5SumLists {
    private fun sumLists(node1: Node?, node2: Node?): Node? {
        var head: Node? = null
        var tail: Node? = null
        var curr1: Node? = node1
        var curr2: Node? = node2
        var carry = 0

        while (curr1 != null || curr2 != null) {
            var value = 0
            curr1?.let {
                value += it.value
                curr1 = it.next
            }
            curr2?.let {
                value += it.value
                curr2 = it.next
            }
            value += carry
            if (value >= 10) {
                carry = 1
                value %= 10
            }
            when (head) {
                null -> {
                    head = Node(value, null)
                    tail = head
                }
                else -> {
                    tail!!.next = Node(value, null)
                    tail = tail.next
                }
            }
        }
        return head
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

    class PartialSum(
        var sum: Node? = null,
        var carry: Int = 0
    )

    private fun sumListsForward(list1: Node?, list2: Node?): Node? {
        var l1 = list1
        var l2 = list2
        val len1 = length(l1)
        val len2 = length(l2)
        when {
            len1 > len2 -> l2 = padList(l2, len1 - len2)
            len2 > len1 -> l1 = padList(l1, len2 - len1)
        }
        val sum = addListsHelper(l1, l2)
        return when (sum.carry) {
            0 -> sum.sum
            else -> insertBefore(sum.sum, sum.carry)
        }
    }

    private fun length(head: Node?): Int {
        var node = head
        var length = 0
        while (node != null) {
            length++
            node = node.next
        }
        return length
    }

    private fun padList(headNode: Node?, padLength: Int): Node? {
        var head = headNode
        for (i in 1..padLength) {
            head = when (head) {
                null -> Node(0, null)
                else -> Node(0, head)
            }
        }
        return head
    }

    private fun addListsHelper(l1: Node?, l2: Node?): PartialSum {
        if (l1 == null && l2 == null) {
            return PartialSum()
        }
        val sum = addListsHelper(l1!!.next, l2!!.next)
        val value = sum.carry + l1.value + l2.value
        val fullResult = insertBefore(sum.sum, value % 10)
        sum.sum = fullResult
        sum.carry = value / 10
        return sum
    }

    private fun insertBefore(node: Node?, value: Int): Node {
        return Node(value, node)
    }

    fun runTest() {
        val functions = arrayListOf(this::sumLists, this::sumListsRec, this::sumListsForward)

        val testCases = arrayListOf(
            Pair(LinkedListUtil.sumList1, LinkedListUtil.sumList2),
            Pair(LinkedListUtil.sumList3, LinkedListUtil.sumList4),
            Pair(null, null)
        )

        for (function in functions) {
            println("Using ${function.name}:")
            for (case in testCases) {
                println(LinkedListUtil.listAsString(case.first))
                println("+")
                println(LinkedListUtil.listAsString(case.second))
                println("=")
                val result = function(case.first, case.second)
                println(LinkedListUtil.listAsString(result))
                println()
            }
            println("------------------------------------------")
        }
    }
}