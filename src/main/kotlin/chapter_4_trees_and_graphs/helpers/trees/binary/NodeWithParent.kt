package chapter_4_trees_and_graphs.helpers.trees.binary

class NodeWithParent(
    var value: Int,
    var parent: NodeWithParent? = null,
    var left: NodeWithParent? = null,
    var right: NodeWithParent? = null,
    var visited: Boolean = false
)