package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.TreeWithParentsUtil
import chapter_4_trees_and_graphs.helpers.TreeNodeWithParent

class S6Successor {
    private fun getSuccessor(node: TreeNodeWithParent?): TreeNodeWithParent? {
        if (node == null) {
            return null
        }

        if (node.right != null) {
            return node.right
        }

        var current = node
        while (current!!.parent != null && current.parent!!.right == current) {
            current = current.parent
        }

        return current.parent
    }

    fun runTest() {
        val functions = arrayListOf(this::getSuccessor)
        val tree = TreeWithParentsUtil.buildTreeWithParents()
        TreeWithParentsUtil.printBinaryTreeViaDepths(tree)

        val testCases = arrayListOf(
            TreeWithParentsUtil.node0,
            TreeWithParentsUtil.node1,
            TreeWithParentsUtil.node2,
            TreeWithParentsUtil.node3,
            TreeWithParentsUtil.node4,
            TreeWithParentsUtil.node5,
        )

        for (function in functions) {
            for (testCase in testCases) {
                println("${testCase.value} -> ${function(testCase)?.value}")
            }
        }
    }
}