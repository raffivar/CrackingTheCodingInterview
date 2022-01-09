package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.Node

class S2MinimalTree {
    private fun binarySearchTree(array: Array<Int>): Node? {

        if (array.isEmpty()) {
            return null
        }
        val root = Node(array[0])
        val left = null
        val right = binarySearchTree(array.sliceArray(1 until array.size))
        val children = arrayOf(left, right)
        root.children = children

        return root
    }

    fun runTest() {
        val array1 = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
        val root = binarySearchTree(array1)
        printBinaryTree(root)
    }

    private fun printBinaryTree(root: Node?) {
        printBinaryTree(root, 0)

    }

    private fun printBinaryTree(root: Node?, level: Int) {
        if (root == null) {
            return
        }

        printBinaryTree(root.children?.get(1), level + 1)

        if (level != 0) {
            for (i in 0 until level - 1) print("|\t")
            println("|-------" + root.value)
        } else {
            println(root.value)
        }

        printBinaryTree(root.children?.get(0), level + 1)
    }
}