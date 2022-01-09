package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.trees.TreeWithParentsUtil
import chapter_4_trees_and_graphs.helpers.trees.binary.NodeWithParent

class S6Successor {
    private fun getSuccessor(node: NodeWithParent?): NodeWithParent? {
        if (node == null) {
            return null
        }

        val right = node.right
        if (right != null && !right.visited) {
            return node.right
        }

        node.visited = true

        val parent = node.parent
        if (parent != null && parent.left == node) {
            return parent
        }

        return getSuccessor(parent)
    }

    fun runTest() {
        val functions = arrayListOf(this::getSuccessor)
        val tree = TreeWithParentsUtil.buildTreeWithParents()
        TreeWithParentsUtil.printBinaryTreeViaDepths(tree)

        val testCases = arrayListOf(
            TreeWithParentsUtil.node3
        )

        for (function in functions) {
            for (testCase in testCases) {
                println("${testCase.value} -> ${function(testCase)?.value}")
            }
        }
    }
}