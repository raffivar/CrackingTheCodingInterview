package chapter_2_linked_lists.util

object LinkedListUtil {
    val list1 = Node(1, Node(2, Node(3, Node(4, Node(5, Node(6, Node(7, null)))))))
    val list2 = Node(1, Node(2, Node(3, Node(4, null))))
    val list3 = Node(1, Node(2, null))
    val list4 = Node(3, Node(5, Node(8, Node(5, Node(10, Node(2, Node(1, null)))))))
    val list5 = Node(3, Node(10, Node(8, Node(5, Node(10, Node(2, Node(1, null)))))))
    val list6 = Node(1, Node(2, Node(3, Node(4, Node(3, Node(2, Node(1, null)))))))
    val list7 = Node(1, null)

    val sumList1 = Node(7, Node(1, Node(6, null)))
    val sumList2 = Node(5, Node(9, Node(2, null)))

    val sumList3 = Node(7, Node(1, Node(6, null)))
    val sumList4 = Node(5, Node(9, null))

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