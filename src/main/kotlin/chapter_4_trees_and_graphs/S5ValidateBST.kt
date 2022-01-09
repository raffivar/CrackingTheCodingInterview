package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.trees.binary.Node
import chapter_4_trees_and_graphs.helpers.trees.TreeUtil

class S5ValidateBST {
    private fun isBinarySearchTree(root: Node?): Boolean {
        if (root == null) {
            return true
        }

        val left = root.left
        val right = root.right

        if (left != null && left.value > root.value ||
            right != null && right.value < root.value) {
            return false
        }

        if (!isBinarySearchTree(left)) {
            return false
        }

        if (!isBinarySearchTree(right)) {
            return false
        }

        return true
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