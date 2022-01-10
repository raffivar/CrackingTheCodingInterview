package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.trees.binary.Node
import chapter_4_trees_and_graphs.helpers.trees.TreeUtil
import kotlin.math.pow

class S9BSTSequence {
    private fun allSequences(root: Node?): MutableList<MutableList<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        if (root == null) {
            result.add(mutableListOf())
            return result
        }
        val prefix = mutableListOf<Int>()
        prefix.add(root.value)

        val leftScq = allSequences(root.left)
        val rightScq = allSequences(root.right)

        for (left in leftScq) {
            for (right in rightScq) {
                val weaved = mutableListOf<MutableList<Int>>()
                weaveLists(left, right, weaved, prefix)
                result.addAll(weaved)
            }
        }
        return result
    }

    private fun weaveLists(first: MutableList<Int>, second: MutableList<Int>, results: MutableList<MutableList<Int>>, prefix: MutableList<Int>) {
        if (first.isEmpty() || second.isEmpty()) {
            val result = prefix.toMutableList()
            result.addAll(first)
            result.addAll(second)
            results.add(result)
            return
        }

        val headFirst = first.removeFirst()
        prefix.add(headFirst)
        weaveLists(first, second, results, prefix)
        prefix.removeLast()
        first.add(0, headFirst)

        val headSecond = second.removeFirst()
        prefix.add(headSecond)
        weaveLists(first, second, results, prefix)
        prefix.removeLast()
        second.add(0, headSecond)
    }


    fun runTest() {
        val root = buildTree()
        TreeUtil.printBinaryTreeViaDepths(root)
        printResult(root)
    }

    private fun printResult(root: Node?) {
        val result = allSequences(root)
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