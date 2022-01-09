package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.trees.TreeWithParentsUtil
import chapter_4_trees_and_graphs.helpers.trees.binary.NodeWithParent

class S6Successor {
    private fun getSuccessor(node: NodeWithParent?): NodeWithParent? {
        if (node == null) {
            return null
        }

        if (node.parent == null || node.right != null) {
            return node.right
        }

        return null
    }

    fun runTest() {
        val functions = arrayListOf(this::getSuccessor)
        val testCases = arrayListOf(
            TreeWithParentsUtil.buildTreeWithParents()
        )

        for (function in functions) {
            for (testCase in testCases) {
                TreeWithParentsUtil.printBinaryTreeViaDepths(testCase)
                println(function(testCase))
            }
        }
    }
}