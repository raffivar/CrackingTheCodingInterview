package chapter_4_trees_and_graphs.helpers.trees.binary

class Node(
    var value: Int,
    var left: Node? = null,
    var right: Node? = null,
    var visited: Boolean = false,
)