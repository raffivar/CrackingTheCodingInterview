package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.trees.binary.Node
import chapter_4_trees_and_graphs.helpers.trees.TreeUtil

class S10CheckSubtree {
    private fun isSubtree(root1: Node?, root2: Node?): Boolean {
        return when {
            isSameTree(root1, root2) -> true
            root1 == null -> false //root2 is not null, otherwise isSameTree would have already returned 'true'
            isSubtree(root1.left, root2) -> true
            isSubtree(root1.right, root2) -> true
            else -> false
        }
    }

    private fun isSameTree(root1: Node?, root2: Node?): Boolean {
        return when {
            root1 == null && root2 == null -> return true
            root1 == null || root2 == null -> return false
            root1.value != root2.value -> false
            !isSameTree(root1.left, root2.left) -> false
            !isSameTree(root1.right, root2.right) -> false
            else -> true
        }
    }

    fun runTest() {
        val tree1 = buildTree1()
        val tree2 = buildTree2()
        TreeUtil.printBinaryTreeViaDepths(tree1)
        TreeUtil.printBinaryTreeViaDepths(tree2)
        println(isSubtree(tree1, tree2))
    }

    private val nodes = listOf(
        Node(50),
        Node(20),
        Node(60),
        Node(10),
        Node(25),
        Node(70),
        Node(5),
        Node(15),
        Node(65),
        Node(80)
    )

    private fun buildTree1(): Node {
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

    private fun buildTree2(): Node {
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