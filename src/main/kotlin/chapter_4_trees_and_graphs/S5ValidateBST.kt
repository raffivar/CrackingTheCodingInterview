package chapter_4_trees_and_graphs

import Solution
import chapter_4_trees_and_graphs.helpers.TreeNode
import chapter_4_trees_and_graphs.helpers.TreeUtil

class S5ValidateBST : Solution {
    private fun isBinarySearchTree(root: TreeNode?): Boolean {
        return when {
            root == null -> true
            root.left != null && root.left!!.value > root.value -> false
            root.right != null && root.right!!.value < root.value -> false
            !isBinarySearchTree(root.left) -> false
            !isBinarySearchTree(root.right) -> false
            else -> true
        }
    }

    override fun runTest() {
        val functions = arrayListOf(this::isBinarySearchTree)
        val testCases = arrayListOf(
            TreeUtil.buildBinaryTree(),
            TreeUtil.buildBinaryTree2(),
            TreeUtil.buildBinaryTree3(),
            TreeUtil.buildBST()
        )

        for (function in functions) {
            for (case in testCases) {
                println("--------------------------------------")
                println("is BST (Binary Search Tree)? -> ${function(case)}\n")
                TreeUtil.printBinaryTreeViaDepths(case)
            }
        }
    }
}