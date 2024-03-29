package chapter_4_trees_and_graphs

import Solution
import chapter_4_trees_and_graphs.helpers.TreeNode
import chapter_4_trees_and_graphs.helpers.TreeUtil

/** There is a more optimal solution that that doesn't sum the same branches twice */
class S12PathsWithSum : Solution {
    private fun numOfPaths(node: TreeNode?, sum: Int): Int {
        return when (node) {
            null -> 0
            else -> numOfPathsFromSpecificNode(node, 0, sum) +
                    numOfPaths(node.left, sum) +
                    numOfPaths(node.right, sum)
        }
    }

    private fun numOfPathsFromSpecificNode(node: TreeNode?, currentSum: Int, totalSum: Int): Int {
        if (node == null) {
            return 0
        }
        val sum = currentSum + node.value
        var numOfPaths = 0
        if (sum == totalSum) {
            numOfPaths++
        }
        numOfPaths += numOfPathsFromSpecificNode(node.left, sum, totalSum)
        numOfPaths += numOfPathsFromSpecificNode(node.right, sum, totalSum)
        return numOfPaths
    }

    override fun runTest() {
        val root = TreeUtil.buildBinaryTree9()
        TreeUtil.printBinaryTreeViaDepths(root)
        printResult(root, 7)
        printResult(root, 5)
        printResult(root, -2)
        printResult(root, 18)
    }

    private fun printResult(root: TreeNode?, sum: Int) {
        println("Number of paths to create [$sum] -> ${numOfPaths(root, sum)}")
    }
}