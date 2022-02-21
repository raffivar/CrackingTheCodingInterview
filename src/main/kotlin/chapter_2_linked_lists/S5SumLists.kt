package chapter_2_linked_lists

import chapter_2_linked_lists.util.LinkedListUtil
import chapter_2_linked_lists.util.Node

class S5SumLists {
    private fun sumLists(node1: Node, node2: Node): Node? {
        var result: Node? = null
        var last: Node? = null
        var curr1: Node? = node1
        var curr2: Node? = node2
        var carry = 0

        while (curr1 != null && curr2 != null) {
            var currResult = curr1.value + curr2.value + carry
            carry = currResult / 10
            currResult %= 10
            when (result) {
                null -> {
                    result = Node(currResult, null)
                    last = result
                }
                else -> {
                    last!!.next = Node(currResult, null)
                    last = last.next
                }
            }
            curr1 = curr1.next
            curr2 = curr2.next
        }

        while (curr1 != null) {
            var currResult = curr1.value + 0 + carry
            carry = currResult / 10
            currResult %= 10
            when (result) {
                null -> {
                    result = Node(currResult, null)
                    last = result
                }
                else -> {
                    last!!.next = Node(currResult, null)
                    last = last.next
                }
            }
            curr1 = curr1.next
        }

        while (curr2 != null) {
            var currResult = 0 + curr2.value + carry
            carry = currResult / 10
            currResult %= 10
            when (result) {
                null -> {
                    result = Node(currResult, null)
                    last = result
                }
                else -> {
                    last!!.next = Node(currResult, null)
                    last = last.next
                }
            }
            curr2 = curr2.next
        }

        return result
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
            Pair(LinkedListUtil.sumList3, LinkedListUtil.sumList4)
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