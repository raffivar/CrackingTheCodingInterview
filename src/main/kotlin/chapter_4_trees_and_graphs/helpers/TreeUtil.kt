package chapter_4_trees_and_graphs.helpers

object TreeUtil {
    fun printBinaryTree(root: TreeNode?) {
        printBinaryTree(root, 0)
    }

    private fun printBinaryTree(root: TreeNode?, level: Int) {
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

    fun printBinaryTreeViaDepths(root: TreeNode?) {
        printDepthsList(listOfDepth(root))
    }

    private fun listOfDepth(root: TreeNode?): List<List<TreeNode?>> {
        val lists = mutableListOf<MutableList<TreeNode?>>()
        if (root == null) {
            return lists
        }
        addDepths(root, lists, 0)
        lists.removeLast() //Removing last level, all null
        return lists
    }

    private fun addDepths(root: TreeNode?, lists: MutableList<MutableList<TreeNode?>>, level: Int) {
        if (level >= lists.size) { //new depth
            val list = mutableListOf<TreeNode?>()
            lists.add(list)
        }
        val depthList = lists[level]
        depthList.add(root)
        root?.let {
            addDepths(it.left, lists, level + 1)
            addDepths(it.right, lists, level + 1)
        }
    }

    fun printDepthsList(list: List<List<TreeNode?>>) {
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

    fun buildBinaryTree(): TreeNode {
        return TreeNode(
            1,
            TreeNode(
                2,
                TreeNode(4),
                TreeNode(5)
            ),
            TreeNode(
                3,
                TreeNode(6),
                TreeNode(7)
            )
        )
    }

    fun buildBinaryTree2(): TreeNode {
        return TreeNode(
            1,
            TreeNode(
                2,
                TreeNode(4),
                TreeNode(5)
            ),
            TreeNode(
                3,
                TreeNode(6),
            )
        )
    }

    fun buildBinaryTree3(): TreeNode {
        return TreeNode(
            1,
            TreeNode(
                2,
                TreeNode(4),
                TreeNode(5)
            ),
            TreeNode(
                3,
                null,
                TreeNode(7)
            )
        )
    }

    fun buildBinaryTree4(): TreeNode {
        return TreeNode(
            1,
            TreeNode(
                2,
                TreeNode(4),
                TreeNode(
                    5,
                    TreeNode(8),
                    TreeNode(9)
                )
            ),
            TreeNode(
                3,
                null,
                TreeNode(7)
            )
        )
    }

    fun buildBinaryTree5(): TreeNode {
        return TreeNode(1)
    }

    fun buildBinaryTree6(): TreeNode? {
        return null
    }

    fun buildBinaryTree7(): TreeNode {
        return TreeNode(
            1,
            TreeNode(
                2,
                TreeNode(4),
                TreeNode(5)
            ),
            TreeNode(
                -3,
                TreeNode(6),
                TreeNode(
                    7
                )
            )
        )
    }


    fun buildBinaryTree8(): TreeNode {
        return TreeNode(
            1,
            TreeNode(
                3,
                null,
                TreeNode(
                    7,
                    TreeNode(8),
                    TreeNode(9)
                )
            )
        )
    }

    fun buildBST(): TreeNode {
        return TreeNode(
            8,
            TreeNode(
                4,
                TreeNode(2),
                TreeNode(6)
            ),
            TreeNode(
                10,
                null,
                TreeNode(20)
            )
        )
    }
}