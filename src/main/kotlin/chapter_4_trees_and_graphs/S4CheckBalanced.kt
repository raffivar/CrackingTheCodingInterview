package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.trees.binary.Node
import chapter_4_trees_and_graphs.helpers.trees.TreeUtil
import kotlin.math.abs
import kotlin.math.max

class S4CheckBalanced {
    private fun checkBalanced(node: Node?): Boolean {
        return when {
            node == null -> true
            abs(treeHeight(node.left) - treeHeight(node.right)) > 1 -> false
            else -> checkBalanced(node.left) && checkBalanced(node.right)
        }
    }

    private fun treeHeight(node: Node?): Int {
        if (node == null) {
            return 0
        }
        var height = 1
        val heightLeft = treeHeight(node.left)
        val heightRight = treeHeight(node.right)
        height += max(heightLeft, heightRight)
        return height
    }

    fun runTest() {
        val functions = arrayListOf(this::checkBalanced)
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
            for (testCase in testCases) {
                TreeUtil.printBinaryTreeViaDepths(testCase)
                println("Height: ${treeHeight(testCase)}")
                println("isBalanced: ${checkBalanced(testCase)}")
                println("-----------------------------------------")
            }
        }
    }
}