package chapter_4_trees_and_graphs.helpers

class Node(
    var visited: Boolean = false,
    var value: Int,
    var children: Array<Node>?  = null
    )