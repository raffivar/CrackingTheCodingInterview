package chapter_4_trees_and_graphs.helpers

object TreeWithParentsUtil {
    val node0 = TreeNodeWithParent(8)
    val node1 = TreeNodeWithParent(4, node0)
    val node2 = TreeNodeWithParent(2, node1)
    val node3 = TreeNodeWithParent(6, node1)
    val node4 = TreeNodeWithParent(10, node0)
    val node5 = TreeNodeWithParent(20, node4)

    fun buildTreeWithParents(): TreeNodeWithParent {
        node0.left = node1
        node0.right = node4

        node1.left = node2
        node1.right = node3

        node4.right = node5

        return node0
    }


    fun printBinaryTreeViaDepths(root: TreeNodeWithParent?) {
        printDepthsList(listOfDepth(root))
    }

    private fun listOfDepth(root: TreeNodeWithParent?): List<List<TreeNodeWithParent?>> {
        val lists = mutableListOf<MutableList<TreeNodeWithParent?>>()
        if (root == null) {
            return lists
        }
        addDepths(root, lists, 0)
        lists.removeLast() //Removing last level, all null
        return lists
    }

    private fun addDepths(root: TreeNodeWithParent?, lists: MutableList<MutableList<TreeNodeWithParent?>>, level: Int) {
        if (level >= lists.size) { //new depth
            val list = mutableListOf<TreeNodeWithParent?>()
            lists.add(list)
        }
        val depthList = lists[level]
        depthList.add(root)
        root?.let {
            addDepths(it.left, lists, level + 1)
            addDepths(it.right, lists, level + 1)
        }
    }

    private fun printDepthsList(list: List<List<TreeNodeWithParent?>>) {
        for ((level, depth) in list.withIndex()) {
            val defaultValuePadding = list.size - level + 1
            val defaultLegPadding = list.size - level + 2
            // print values
            for ((i, node) in depth.withIndex()) {
                val value = when (node) {
                    null -> "?"
                    else -> node.value
                }
                val padding = when ((level > 1) && (i % 2 == 1) && (list[level - 1][i / 2] == null)) {
                    true -> 4
                    false -> defaultValuePadding
                }
                print(value.toString().padStart(padding))
            }
            println()
            // print "legs"
            if (level < list.size - 1) { // not printing legs for last level
                for (node in depth) {
                    val value = when (node) {
                        null -> ""
                        else -> "/ \\"
                    }
                    val padding = when (node) {
                        null -> 1
                        else -> defaultLegPadding
                    }
                    print(value.padStart(padding))
                }
            }
            println()
        }
    }
}