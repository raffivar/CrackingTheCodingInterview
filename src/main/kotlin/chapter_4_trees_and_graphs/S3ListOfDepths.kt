package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.trees.binary.Node
import chapter_4_trees_and_graphs.helpers.trees.TreeUtil

class S3ListOfDepths {
    private fun listOfDepths(root: Node?): List<List<Node?>> {
        val lists = mutableListOf<MutableList<Node?>>()
        if (root == null) {
            return lists
        }
        addDepths(root, lists, 0)
        return lists
    }

    private fun addDepths(root: Node, lists: MutableList<MutableList<Node?>>, level: Int) {
        if (level >= lists.size) { //new depth
            val list = mutableListOf<Node?>()
            lists.add(list)
        }
        val depthList = lists[level]
        depthList.add(root)
        root.left?.let {
            addDepths(it, lists, level + 1)
        }
        root.right?.let {
            addDepths(it, lists, level + 1)
        }
    }

    fun runTest() {
        val root = TreeUtil.buildBinaryTree()
        val depthsList = listOfDepths(root)
        TreeUtil.printDepthsList(depthsList)
    }
}