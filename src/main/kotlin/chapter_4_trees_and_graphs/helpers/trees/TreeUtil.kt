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

    fun printDepthsList(list: List<List<Node?>>) {
        for ((level, depth) in list.withIndex()) {
            val defaultValuePadding = list.size - level + 1
            val defaultLegPadding = list.size - level + 2
            // print values
            for ((i, node) in depth.withIndex()) {
                val value = when (node) {
                    null -> "?"
                    else -> node.value
                }
                val padding = when ((level > 1) && (i % 2 == 1) && (list[level - 1][i / 2] == null)) {
                    true -> 4
                    false -> defaultValuePadding
                }
                print(value.toString().padStart(padding))
            }
            println()
            // print "legs"
            if (level < list.size - 1) { // not printing legs for last level
                for (node in depth) {
                    val value = when (node) {
                        null -> ""
                        else -> "/ \\"
                    }
                    val padding = when (node) {
                        null -> 1
                        else -> defaultLegPadding
                    }
                    print(value.padStart(padding))
                }
            }
            println()
        }
    }

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
        return Node(
            1,
            Node(
                2,
                Node(4),
                Node(
                    5,
                    Node(8),
                    Node(9)
                )
            ),
            Node(
                3,
                null,
                Node(7)
            )
        )
    }


    fun buildBinaryTree5(): Node {
        return Node(1)
    }

    fun buildBinaryTree6(): Node? {
        return null
    }

    fun buildBST(): Node? {
        return Node(
            8,
            Node(
                4,
                Node(2),
                Node(6)
            ),
            Node(
                10,
                null,
                Node(20)
            )
        )
    }
}