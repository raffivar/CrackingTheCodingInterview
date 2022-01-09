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

    private fun listOfDepthsAdvanced(root: Node?): List<List<Node?>> {
        val lists = mutableListOf<MutableList<Node?>>()
        if (root == null) {
            return lists
        }
        addDepthsAdvanced(root, lists, 0)
        lists.removeLast() //Removing last level, all null
        return lists
    }

    private fun addDepthsAdvanced(root: Node?, lists: MutableList<MutableList<Node?>>, level: Int) {
        if (level >= lists.size) { //new depth
            val list = mutableListOf<Node?>()
            lists.add(list)
        }
        val depthList = lists[level]
        depthList.add(root)
        root?.let {
            addDepthsAdvanced(it.left, lists, level + 1)
            addDepthsAdvanced(it.right, lists, level + 1)
        }
    }

    fun runTest() {
        val root = TreeUtil.buildBinaryTree()
        //TreeUtil.printBinaryTree(root)
        val depthsList = listOfDepthsAdvanced(root)
        TreeUtil.printDepthsList(depthsList)
    }
}