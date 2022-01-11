package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.TreeNode
import chapter_4_trees_and_graphs.helpers.TreeUtil

class S10CheckSubtree {
    private fun isSubtree(root1: TreeNode?, root2: TreeNode?): Boolean {
        return when {
            isSameTree(root1, root2) -> true
            root1 == null -> false //root2 is not null, otherwise isSameTree would have already returned 'true'
            isSubtree(root1.left, root2) -> true
            isSubtree(root1.right, root2) -> true
            else -> false
        }
    }

    private fun isSameTree(root1: TreeNode?, root2: TreeNode?): Boolean {
        return when {
            root1 == null && root2 == null -> true
            root1 == null || root2 == null -> false
            root1.value != root2.value -> false
            !isSameTree(root1.left, root2.left) -> false
            !isSameTree(root1.right, root2.right) -> false
            else -> true
        }
    }

    fun runTest() {
        val functions = arrayListOf(this::isSubtree)
        val testCases = arrayListOf(Pair(buildTree1(), buildTree2()))
        for (function in functions) {
            for (case in testCases) {
                println("Is this tree")
                TreeUtil.printBinaryTreeViaDepths(case.second)
                println("A subtree of this tree?")
                TreeUtil.printBinaryTreeViaDepths(case.first)
                println("Answer: ${function(case.first, case.second)}")
            }
        }
    }

    private val nodes = listOf(
        TreeNode(50),
        TreeNode(20),
        TreeNode(60),
        TreeNode(10),
        TreeNode(25),
        TreeNode(70),
        TreeNode(5),
        TreeNode(15),
        TreeNode(65),
        TreeNode(80)
    )

    private fun buildTree1(): TreeNode {
        nodes[0].left = nodes[1]
        nodes[0].right = nodes[2]

        nodes[1].left = nodes[3]
        nodes[1].right = nodes[4]

        nodes[2].right = nodes[5]

        nodes[3].left = nodes[6]
        nodes[3].right = nodes[7]

        nodes[5].left = nodes[8]
        nodes[5].right = nodes[9]

        return nodes[0]
    }

    private fun buildTree2(): TreeNode {
        nodes[0].left = nodes[1]
        nodes[0].right = nodes[2]

        nodes[1].left = nodes[3]
        nodes[1].right = nodes[4]

        nodes[2].right = nodes[5]

        nodes[3].left = nodes[6]
        nodes[3].right = nodes[7]

        nodes[5].left = nodes[8]
        nodes[5].right = nodes[9]

        return nodes[2]
    }
}