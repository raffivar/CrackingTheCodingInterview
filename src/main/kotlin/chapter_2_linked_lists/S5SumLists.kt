package chapter_2_linked_lists

import chapter_2_linked_lists.util.LinkedListUtil
import chapter_2_linked_lists.util.Node

class S5SumLists {
    private fun sumLists(node1: Node, node2: Node): Node? {
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

    fun runTest() {
        val functions = arrayListOf(this::sumLists, this::sumListsRec)

        val testCases = arrayListOf(
            Pair(LinkedListUtil.sumList1, LinkedListUtil.sumList2),
            Pair(LinkedListUtil.sumList3, LinkedListUtil.sumList4),
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