package chapter_4_trees_and_graphs

import Solution
import chapter_4_trees_and_graphs.helpers.TreeNode
import chapter_4_trees_and_graphs.helpers.TreeUtil
import kotlin.math.abs
import kotlin.math.max

class S4CheckBalanced : Solution {
    private fun isBalanced(node: TreeNode?): Boolean {
        return when {
            node == null -> true
            abs(treeHeight(node.left) - treeHeight(node.right)) > 1 -> false
            else -> isBalanced(node.left) && isBalanced(node.right)
        }
    }

    private fun treeHeight(node: TreeNode?): Int {
        return when (node) {
            null -> -1
            else -> 1 + max(treeHeight(node.left), treeHeight(node.right))
        }
    }

    override fun runTest() {
        val functions = arrayListOf(this::isBalanced)
        val testCases = arrayListOf(
            TreeUtil.buildBinaryTree(),
            TreeUtil.buildBinaryTree2(),
            TreeUtil.buildBinaryTree3(),
            TreeUtil.buildBinaryTree4(),
            TreeUtil.buildBinaryTree5(),
            TreeUtil.buildBinaryTree5(),
            TreeUtil.buildBinaryTree6(),
            TreeUtil.buildBinaryTree7(),
            TreeUtil.buildBinaryTree8(),
        )

        for (function in functions) {
            for (case in testCases) {
                TreeUtil.printBinaryTreeViaDepths(case)
                println("Height: ${treeHeight(case)}")
                println("isBalanced: ${isBalanced(case)}")
                println("-----------------------------------------")
            }
        }
    }
}