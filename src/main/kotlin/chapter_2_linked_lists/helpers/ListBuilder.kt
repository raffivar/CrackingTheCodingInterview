package chapter_2_linked_lists.helpers

object ListBuilder {
    val list1 = buildList1()
    val list2 = buildList2()
    val list3 = buildList3()

    private fun buildList1(): Node {
        val node4 = Node(5, null)
        val node3 = Node(4, node4)
        val node2 = Node(3, node3)
        val node1 = Node(2, node2)
        return Node(1, node1) // Node 0
    }

    private fun buildList2(): Node {
        val node3 = Node(4, null)
        val node2 = Node(3, node3)
        val node1 = Node(2, node2)
        return Node(1, node1) // Node 0
    }

    private fun buildList3(): Node {
        val node1 = Node(2, null)
        return Node(1, node1) // Node 0
    }

    fun listAsString(node: Node?): String {
        val sb = StringBuilder()
        var current = node
        while (current != null) {
            sb.append("${current.value} -> ")
            current = current.next
        }
        sb.append("||")
        return sb.toString()
    }
}