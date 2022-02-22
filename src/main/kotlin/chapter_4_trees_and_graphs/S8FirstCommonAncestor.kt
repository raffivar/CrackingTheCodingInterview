package chapter_4_trees_and_graphs

import Solution
import chapter_4_trees_and_graphs.helpers.TreeNode
import chapter_4_trees_and_graphs.helpers.TreeNodeWithParent
import chapter_4_trees_and_graphs.helpers.TreeUtil
import chapter_4_trees_and_graphs.helpers.TreeWithParentsUtil

class S8FirstCommonAncestor : Solution {
    private fun firstCommonAncestor(root: TreeNode?, node1: TreeNode?, node2: TreeNode?): TreeNode? {
        if (root == null || root == node1 || root == node2) {
            return null
        }

        if (!isAncestor(root, node1) || !isAncestor(root, node2)) {
            return null
        }

        val left = firstCommonAncestor(root.left, node1, node2)
        if (left != null) {
            return left
        }

        val right = firstCommonAncestor(root.right, node1, node2)
        if (right != null) {
            return right
        }

        return root
    }

    private fun isAncestor(node1: TreeNode?, node2: TreeNode?): Boolean {
        return when {
            node1 == null -> false
            node1.left == node2 || node1.right == node2 -> true
            isAncestor(node1.left, node2) || isAncestor(node1.right, node2) -> true
            else -> false
        }
    }

    private fun firstCommonAncestorWithParent(
        node1: TreeNodeWithParent?,
        node2: TreeNodeWithParent?
    ): TreeNodeWithParent? {
        return when {
            node1 == null || node2 == null -> null
            node1.parent == null -> null
            isAncestor(node1.parent, node2) -> node1.parent
            else -> firstCommonAncestorWithParent(node1.parent, node2)
        }
    }

    private fun isAncestor(node1: TreeNodeWithParent?, node2: TreeNodeWithParent?): Boolean {
        return when {
            node1 == null -> false
            node1.left == node2 || node1.right == node2 -> true
            isAncestor(node1.left, node2) || isAncestor(node1.right, node2) -> true
            else -> false
        }
    }

    override fun runTest() {
        val functions = arrayListOf(this::firstCommonAncestor)
        val testCases = arrayListOf(
            Pair(nodes[5], nodes[6]),
            Pair(nodes[3], nodes[6]),
            Pair(nodes[3], nodes[7]),
            Pair(nodes[3], nodes[4]),
            Pair(nodes[5], nodes[7]),
            Pair(nodes[5], nodes[2]),
            Pair(nodes[5], nodes[1]),
            Pair(nodes[3], nodes[0])
        )
        val root = buildTree()
        TreeUtil.printBinaryTreeViaDepths(root)
        for (function in functions) {
            for (case in testCases) {
                val result = when (val commonAncestor = firstCommonAncestor(root, case.first, case.second)) {
                    null -> "No mutual parent"
                    else -> commonAncestor.value
                }
                println("[${case.first.value}] + [${case.first.value}] -> $result")
            }
        }
        println("\n====================== AND NOW, WITH PARENTS! :D ========================")
        val rootWithParents = TreeWithParentsUtil.buildTreeWithParents2()
        val functionsWithParents = arrayListOf(this::firstCommonAncestorWithParent)
        val testCasesWithParents = arrayListOf(
            Pair(TreeWithParentsUtil.node0, TreeWithParentsUtil.node1),
            Pair(TreeWithParentsUtil.node1, TreeWithParentsUtil.node4),
            Pair(TreeWithParentsUtil.node3, TreeWithParentsUtil.node2),
            Pair(TreeWithParentsUtil.node0, TreeWithParentsUtil.node5),
            Pair(TreeWithParentsUtil.node2, TreeWithParentsUtil.node4),
            Pair(TreeWithParentsUtil.node3, TreeWithParentsUtil.node7),
            Pair(TreeWithParentsUtil.node2, TreeWithParentsUtil.node7),
            Pair(TreeWithParentsUtil.node1, TreeWithParentsUtil.node1)
        )
        TreeWithParentsUtil.printBinaryTreeViaDepths(rootWithParents)
        for (function in functionsWithParents) {
            for (case in testCasesWithParents) {
                val result = when (val commonAncestor = firstCommonAncestorWithParent(case.first, case.second)) {
                    null -> "No mutual parent"
                    else -> commonAncestor.value
                }
                println("[${case.first.value}] + [${case.second.value}] -> $result")
            }
        }
    }

    private val nodes = listOf(
        TreeNode(20),
        TreeNode(10),
        TreeNode(30),
        TreeNode(5),
        TreeNode(15),
        TreeNode(3),
        TreeNode(7),
        TreeNode(17),
    )

    private fun buildTree(): TreeNode {
        nodes[0].left = nodes[1]
        nodes[0].right = nodes[2]

        nodes[1].left = nodes[3]
        nodes[1].right = nodes[4]

        nodes[3].left = nodes[5]
        nodes[3].right = nodes[6]

        nodes[4].right = nodes[7]

        return nodes[0]
    }
}