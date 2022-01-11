package chapter_4_trees_and_graphs.helpers.trees

import chapter_4_trees_and_graphs.helpers.trees.binary.Node
import chapter_4_trees_and_graphs.helpers.trees.binary.NodeWithParent

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

    fun printBinaryTreeViaDepths(root: Node?) {
        printDepthsList(listOfDepth(root))
    }

    private fun listOfDepth(root: Node?): List<List<Node?>> {
        val lists = mutableListOf<MutableList<Node?>>()
        if (root == null) {
            return lists
        }
        addDepths(root, lists, 0)
        lists.removeLast() //Removing last level, all null
        return lists
    }

    private fun addDepths(root: Node?, lists: MutableList<MutableList<Node?>>, level: Int) {
        if (level >= lists.size) { //new depth
            val list = mutableListOf<Node?>()
            lists.add(list)
        }
        val depthList = lists[level]
        depthList.add(root)
        root?.let {
            addDepths(it.left, lists, level + 1)
            addDepths(it.right, lists, level + 1)
        }
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

    fun buildBinaryTree7(): Node {
        return Node(
            1,
            Node(
                2,
                Node(4),
                Node(5)
            ),
            Node(
                -3,
                Node(6),
                Node(
                    7)
            )
        )
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

    fun buildTreeWithParents(): NodeWithParent {
        val node0 = NodeWithParent(8)
        val node1 = NodeWithParent(4, node0)
        val node2 = NodeWithParent(2, node1)
        val node3 = NodeWithParent(6, node1)
        val node4 = NodeWithParent(10, node0)
        val node6 = NodeWithParent(20, node4)

        node0.left = node1
        node0.right = node4

        node1.left = node2
        node1.right = node3

        node4.right = node6

        return node3
    }
}