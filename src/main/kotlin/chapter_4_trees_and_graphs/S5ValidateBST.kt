package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.trees.binary.Node
import chapter_4_trees_and_graphs.helpers.trees.TreeUtil

class S5ValidateBST {
    private fun isBinarySearchTree(root: Node?): Boolean {
        return when {
            root == null -> true
            root.left != null && root.left!!.value > root.value -> false
            root.right != null && root.right!!.value < root.value -> false
            !isBinarySearchTree(root.left) -> false
            !isBinarySearchTree(root.right) -> false
            else -> true
        }
    }

    fun runTest() {
        val functions = arrayListOf(this::isBinarySearchTree)
        val testCases = arrayListOf(
            TreeUtil.buildBinaryTree(),
            TreeUtil.buildBinaryTree2(),
            TreeUtil.buildBinaryTree3(),
            TreeUtil.buildBST()
        )

        for (function in functions) {
            for (testCase in testCases) {
                println(function(testCase))
            }
        }
    }
}