package chapter_4_trees_and_graphs

import Solution
import chapter_4_trees_and_graphs.helpers.TreeNode
import chapter_4_trees_and_graphs.helpers.TreeUtil

class S3ListOfDepths : Solution {
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

    override fun runTest() {
        val functions = arrayListOf(this::listOfDepths)
        val testCases = arrayListOf(TreeUtil.buildBinaryTree())
        for (function in functions) {
            for (case in testCases) {
                val result = function(case)
                println("As list of depths:")
                for (depth in result) {
                    for (item in depth) {
                        print("${item?.value} -> ")
                    }
                    println("||")
                }
                println("\nBack into tree:")
                TreeUtil.printDepthsList(result)
            }
        }
    }
}