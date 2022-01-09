package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.trees.binary.Node
import chapter_4_trees_and_graphs.helpers.trees.TreeUtil

class S2MinimalTree {
    private fun buildMinimalTree(array: Array<Int>): Node? {
        if (array.isEmpty()) {
            return null
        }
        val root = Node(array[0])
        root.left = null
        root.right = buildMinimalTree(array.sliceArray(1 until array.size))
        return root
    }

    fun runTest() {
        val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
        val root = buildMinimalTree(array)
        TreeUtil.printBinaryTree(root)
    }
}