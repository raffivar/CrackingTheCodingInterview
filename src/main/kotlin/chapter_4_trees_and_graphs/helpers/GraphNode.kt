package chapter_4_trees_and_graphs.helpers

class GraphNode(
    var value: Int,
    var children: Array<GraphNode?>? = null,
    var visited: Boolean = false
)