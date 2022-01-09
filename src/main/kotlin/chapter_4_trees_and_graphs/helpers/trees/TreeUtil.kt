package chapter_4_trees_and_graphs.helpers.trees

import chapter_4_trees_and_graphs.helpers.trees.binary.Node

object TreeUtil {
    fun printBinaryTree(root: Node?) {
        printBinaryTree(root, 0)

    }

    private fun printBinaryTree(root: Node?, level: Int) {
        if (root == null) {
            return
        }

        printBinaryTree(root.right, level + 1)

        if (level != 0) {
            for (i in 0 until level - 1) print("|\t")
            println("|-------" + root.value)
        } else {
            println(root.value)
        }

        printBinaryTree(root.left, level + 1)
    }
}