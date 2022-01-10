package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.trees.binary.Node
import chapter_4_trees_and_graphs.helpers.trees.TreeUtil

class S8FirstCommonAncestor {
    private fun firstCommonAncestor(root: Node?, node1: Node?, node2: Node?): Node? {
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

    private fun isAncestor(node1: Node?, node2: Node?): Boolean {
        return when {
            node1 == null -> false
            node1.left == node2 || node1.right == node2 -> true
            isAncestor(node1.left, node2) || isAncestor(node1.right, node2) -> true
            else -> false
        }
    }

    fun runTest() {
        val root = buildTree()
        TreeUtil.printBinaryTreeViaDepths(root)
        printResult(root, nodes[5], nodes[6])
        printResult(root, nodes[3], nodes[6])
        printResult(root, nodes[3], nodes[7])
        printResult(root, nodes[3], nodes[4])
        printResult(root, nodes[5], nodes[7])
        printResult(root, nodes[5], nodes[2])
        printResult(root, nodes[5], nodes[1])
        printResult(root, nodes[3], nodes[0])
    }

    private fun printResult(root: Node?, node1: Node?, node2: Node?) {
        val commonAncestor = firstCommonAncestor(root, node1, node2)
        val result = when (commonAncestor) {
            null -> "No mutual parent"
            else -> commonAncestor.value
        }
        println("[${node1!!.value}] + [${node2!!.value}] -> $result")

    }

    private val nodes = listOf(
        Node(20),
        Node(10),
        Node(30),
        Node(5),
        Node(15),
        Node(3),
        Node(7),
        Node(17),
    )

    private fun buildTree(): Node {
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