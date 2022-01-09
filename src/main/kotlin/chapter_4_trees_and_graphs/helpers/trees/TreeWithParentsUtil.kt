package chapter_4_trees_and_graphs.helpers.trees

import chapter_4_trees_and_graphs.helpers.trees.binary.Node
import chapter_4_trees_and_graphs.helpers.trees.binary.NodeWithParent

object TreeWithParentsUtil {
    val node0 = NodeWithParent(8)
    val node1 = NodeWithParent(4, node0)
    val node2 = NodeWithParent(2, node1)
    val node3 = NodeWithParent(6, node1)
    val node4 = NodeWithParent(10, node0)
    val node6 = NodeWithParent(20, node4)

    fun buildTreeWithParents(): NodeWithParent {
        node0.left = node1
        node0.right = node4

        node1.left = node2
        node1.right = node3

        node4.right = node6

        return node0
    }


    fun printBinaryTreeViaDepths(root: NodeWithParent?) {
        printDepthsList(listOfDepth(root))
    }

    private fun listOfDepth(root: NodeWithParent?): List<List<NodeWithParent?>> {
        val lists = mutableListOf<MutableList<NodeWithParent?>>()
        if (root == null) {
            return lists
        }
        addDepths(root, lists, 0)
        lists.removeLast() //Removing last level, all null
        return lists
    }

    private fun addDepths(root: NodeWithParent?, lists: MutableList<MutableList<NodeWithParent?>>, level: Int) {
        if (level >= lists.size) { //new depth
            val list = mutableListOf<NodeWithParent?>()
            lists.add(list)
        }
        val depthList = lists[level]
        depthList.add(root)
        root?.let {
            addDepths(it.left, lists, level + 1)
            addDepths(it.right, lists, level + 1)
        }
    }

    private fun printDepthsList(list: List<List<NodeWithParent?>>) {
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