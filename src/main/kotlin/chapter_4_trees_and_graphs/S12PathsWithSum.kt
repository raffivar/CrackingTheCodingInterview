package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.trees.binary.Node
import chapter_4_trees_and_graphs.helpers.trees.TreeUtil

class S12PathsWithSum {
    class Paths {
        var numOfPaths = 0
    }

    private fun numOfPaths(root: Node?, sum: Int): Int {
        val paths = Paths()
        numOfPaths(root, sum, paths)
        return paths.numOfPaths
    }

    private fun numOfPaths(node: Node?, sum: Int, paths: Paths) {
        if (node == null) {
            return
        }
        numOfPathsFromSpecificNode(node, 0, sum, paths)
        numOfPaths(node.left, sum, paths)
        numOfPaths(node.right, sum, paths)
    }

    private fun numOfPathsFromSpecificNode(node: Node?, currentSum: Int, totalSum: Int, paths: Paths) {
        if (node == null) {
            return
        }
        val sum = currentSum + node.value
        if (sum == totalSum) {
            paths.numOfPaths++
        }
        numOfPathsFromSpecificNode(node.left, sum, totalSum, paths)
        numOfPathsFromSpecificNode(node.right, sum, totalSum, paths)
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