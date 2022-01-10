package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.trees.binary.Node
import chapter_4_trees_and_graphs.helpers.trees.TreeUtil

class S9BSTSequence {
    private fun getBstSequence(root: Node?): List<List<Int>> {
        return listOf()
    }
    
    fun runTest() {
        val root = buildTree()
        TreeUtil.printBinaryTreeViaDepths(root)
        printResult(root)
    }

    private fun printResult(root: Node?) {
        val result = getBstSequence(root)
        for (list in result) {
            for (num in list) {
                print("$num -> ")
            }
            println("||")
        }
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

    private fun buildTree(): Node {
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
}