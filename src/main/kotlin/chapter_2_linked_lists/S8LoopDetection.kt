package chapter_2_linked_lists

import Solution
import chapter_2_linked_lists.util.Node

class S8LoopDetection : Solution {
    private fun hasLoop(node: Node?): Boolean {
        var curr1 = node
        var curr2 = node
        while (curr1?.next != null && curr2?.next != null) {
            curr1 = curr1.next
            curr2 = curr2.next?.next
            if (curr1 == curr2) {
                return true
            }
        }
        return false
    }

    private fun detectLoop(node: Node?): Node? {
        var curr1 = node
        var curr2 = node
        while (curr1?.next != null && curr2?.next != null) {
            curr1 = curr1.next
            curr2 = curr2.next?.next
            if (curr1 == curr2) { // loop detected
                curr1 = node
                while (curr1 != curr2) {
                    curr1 = curr1!!.next
                    curr2 = curr2!!.next
                }
                return curr1
            }
        }
        return null
    }

    override fun runTest() {
        val functions = arrayListOf(this::hasLoop, this::detectLoop)
        val intersection = Node(5, Node(6, (Node(7, Node(8, null)))))
        val list = Node(1, Node(2, Node(3, Node(4, intersection))))
        intersection.next!!.next!!.next!!.next = list.next!!.next!!.next!!
        val list2 = Node(1, null)
        val list3 = Node(1, Node(2, null))
        val testCases = arrayListOf(list, list2, list3)
        for (function in functions) {
            println("${function.name}:")
            for ((i, case) in testCases.withIndex()) {
                print("case #$i: ")
                when (val result = function(case)) {
                    null -> println("No loop found")
                    is Boolean -> println("Has loop? - $result")
                    is Node? -> println("Loop found - Value of loop node: ${result.value}")
                }
            }
        }
    }
}