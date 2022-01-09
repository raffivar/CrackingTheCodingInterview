package chapter_4_trees_and_graphs.helpers

class Node(
    var value: Int,
    var children: Array<Node>? = null,
    var visited: Boolean = false
)