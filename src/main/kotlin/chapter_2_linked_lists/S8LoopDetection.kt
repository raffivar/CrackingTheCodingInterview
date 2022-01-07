package chapter_2_linked_lists

import chapter_2_linked_lists.helpers.Node

class S8LoopDetection {
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

//                curr2 = curr2!!.next
//                var loopSize = 1
//
//                while (curr2 != curr1) {
//                    curr2 = curr2!!.next
//                    loopSize++
//                }
//
//                curr1 = node
//                while (true) {
//                    for (i in 0..loopSize) {
//                        if (curr2 == curr1) {
//                            return curr2
//                        }
//                        curr2 = curr2!!.next
//                    }
//                    curr1 = curr1!!.next
//                }
            }
        }

        return null
    }

    fun runTest() {
        val functions = arrayListOf(this::detectLoop)
        val intersection = Node(5, Node(6, (Node(7, Node(8, null)))))
        val list = Node(1, Node(2, Node(3, Node(4, intersection))))
        intersection.next!!.next!!.next!!.next = list.next!!.next!!.next!!

        val list2 = Node(1, null)
        val list3 = Node(1, Node(2, null))

        val testCases = arrayListOf(list, list2, list3)

        for (function in functions) {
            for (testCase in testCases) {
                println(function(testCase))
            }
        }
    }
}