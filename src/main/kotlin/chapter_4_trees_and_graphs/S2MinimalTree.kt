package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.TreeNode
import chapter_4_trees_and_graphs.helpers.TreeUtil

class S2MinimalTree {
    private fun buildMinimalTree(array: Array<Int>): TreeNode? {
        if (array.isEmpty()) {
            return null
        }
        val middleIndex = array.size / 2
        val root = TreeNode(array[middleIndex])
        root.left = buildMinimalTree(array.sliceArray(0 until middleIndex))
        root.right = buildMinimalTree(array.sliceArray(middleIndex + 1 until array.size))
        return root
    }

    fun runTest() {
        val functions = arrayListOf(this::buildMinimalTree)
        val testCases = arrayListOf(
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
            arrayOf(10, 20, 30, 40, 50, 60, 70)
        )
        for (function in functions) {
            for (testCase in testCases) {
                val result = function(testCase)
                TreeUtil.printBinaryTreeViaDepths(result)
            }
        }
    }
}