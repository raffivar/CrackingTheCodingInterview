package chapter_4_trees_and_graphs.helpers

class TreeNodeWithParent(
    var value: Int,
    var parent: TreeNodeWithParent? = null,
    var left: TreeNodeWithParent? = null,
    var right: TreeNodeWithParent? = null,
)