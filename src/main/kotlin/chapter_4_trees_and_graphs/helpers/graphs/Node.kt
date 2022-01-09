package chapter_4_trees_and_graphs.helpers.graphs

class Node(
    var value: Int,
    var children: Array<Node?>? = null,
    var visited: Boolean = false,
)