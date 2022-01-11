package chapter_4_trees_and_graphs.helpers

class TreeNodeWithParent(
    var value: Int,
    var left: TreeNodeWithParent? = null,
    var right: TreeNodeWithParent? = null,
    var parent: TreeNodeWithParent? = null
)