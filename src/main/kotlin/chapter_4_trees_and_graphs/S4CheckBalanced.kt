package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.trees.binary.Node
import chapter_4_trees_and_graphs.helpers.trees.TreeUtil

class S4CheckBalanced {
    private fun checkBalanced(root: Node?): Boolean {
        if (root == null) {
            return true
        }

        return true
    }

    fun runTest() {
        val functions = arrayListOf(this::checkBalanced)
        val testCases = arrayListOf(
            TreeUtil.buildBinaryTree(),
            TreeUtil.buildBinaryTree2(),
            TreeUtil.buildBinaryTree3()
        )

        for (function in functions) {
            for (testCase in testCases) {
                println(function(testCase))
            }
        }
    }
}