package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.trees.binary.Node
import chapter_4_trees_and_graphs.helpers.trees.TreeUtil

class S12PathsWithSum {
    private fun numOfPaths(node: Node?, sum: Int): Int {
        return when (node) {
            null -> 0
            else -> numOfPathsFromSpecificNode(node, 0, sum) +
                    numOfPaths(node.left, sum) +
                    numOfPaths(node.right, sum)
        }
    }

    private fun numOfPathsFromSpecificNode(node: Node?, currentSum: Int, totalSum: Int): Int {
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

    fun runTest() {
        val root = TreeUtil.buildBinaryTree7()
        TreeUtil.printBinaryTreeViaDepths(root)
        printResult(root, 7)
        printResult(root, 5)
        printResult(root, -2)
    }

    private fun printResult(root: Node?, sum: Int) {
        println("Number of paths to create [$sum] -> ${numOfPaths(root, sum)}")
    }
}