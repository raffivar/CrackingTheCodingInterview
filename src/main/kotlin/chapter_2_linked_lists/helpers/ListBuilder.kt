package chapter_2_linked_lists.helpers

object ListBuilder {
    val list1 = Node(1, Node(2, Node(3, Node(4, Node(5, Node(6, Node(7, null)))))))
    val list2 = Node(1, Node(2, Node(3, Node(4, null))))
    val list3 = Node(1, Node(2, null))
    val list4 = Node(3, Node(5, Node(8, Node(5, Node(10, Node(2, Node(1, null)))))))
    val list5 = Node(3, Node(10, Node(8, Node(5, Node(10, Node(2, Node(1, null)))))))

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