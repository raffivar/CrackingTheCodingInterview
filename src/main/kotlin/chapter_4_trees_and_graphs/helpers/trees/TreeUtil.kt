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

//    fun printDepthsList(list: List<List<Node?>>) {
//        var level = 0
//        for (depth in list) {
//            for (node in depth) {
//                if (node == null) {
//                    print("?".padStart(list.size - level + 1))
//                } else {
//                    print("${node.value}".padStart(list.size - level + 1))
//                }
//            }
//            println()
//            if (level < list.size - 1) {
//                for (node in depth) {
//                    print("/ \\".padStart(list.size - level + 2))
//                }
//            }
//            println()
//            level++
//        }
//    }

    fun buildBinaryTree(): Node {
        return Node(
            1,
            Node(
                2,
                Node(4),
                Node(5)
            ),
            Node(
                3,
                Node(6),
                Node(7)
            )
        )
    }

    fun buildBinaryTree2(): Node {
        return Node(
            1,
            Node(
                2,
                Node(4),
                Node(5)
            ),
            Node(
                3,
                Node(6),
            )
        )
    }

    fun buildBinaryTree3(): Node {
        return Node(
            1,
            Node(
                2,
                Node(4),
                Node(5)
            ),
            Node(
                3,
                null,
                Node(7)
            )
        )
    }


    fun buildBinaryTree4(): Node {
        return Node(1)
    }

    fun buildBinaryTree5(): Node? {
        return null
    }
}