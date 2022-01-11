package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.TreeNode
import chapter_4_trees_and_graphs.helpers.TreeUtil

class S3ListOfDepths {
    private fun listOfDepths(root: TreeNode?): List<List<TreeNode?>> {
        val lists = mutableListOf<MutableList<TreeNode?>>()
        if (root == null) {
            return lists
        }
        addDepths(root, lists, 0)
        return lists
    }

    private fun addDepths(root: TreeNode, lists: MutableList<MutableList<TreeNode?>>, level: Int) {
        if (level >= lists.size) { //new depth
            val list = mutableListOf<TreeNode?>()
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