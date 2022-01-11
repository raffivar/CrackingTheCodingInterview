package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.TreeNode
import chapter_4_trees_and_graphs.helpers.TreeUtil
import java.util.*
import kotlin.collections.ArrayList

class S11RandomNode {
    class MyBST {
        private var root: TreeNode? = null

        constructor()

        constructor(root: TreeNode?) {
            this.root = root
        }

        fun root(): TreeNode? {
            return root
        }

        fun find(num: Int): TreeNode? {
            return find(root, num)
        }

        private fun find(root: TreeNode?, num: Int): TreeNode? {
            return when {
                root == null -> null // num not found
                root.value > num -> find(root.left, num)
                root.value < num -> find(root.right, num)
                else -> root // num found
            }
        }

        fun insert(num: Int) {
            val node = TreeNode(num)
            when (root) {
                null -> root = node
                else -> insert(root!!, node)
            }
        }

        private fun insert(root: TreeNode, node: TreeNode) {
            when {
                root.value > node.value -> {
                    when (root.left) {
                        null -> root.left = node
                        else -> insert(root.left!!, node)
                    }
                }
                root.value < node.value -> {
                    when (root.right) {
                        null -> root.right = node
                        else -> insert(root.right!!, node)
                    }
                }
                // else -> do nothing, duplicate values are not allowed
            }
        }

        fun remove(num: Int) {
            when {
                root == null -> return // number not found
                root!!.value > num -> remove(root!!, root!!.left!!, num)
                root!!.value < num -> remove(root!!, root!!.right!!, num)
                else -> root = null // root is the number
            }
        }

        private fun remove(parent: TreeNode, node: TreeNode?, num: Int) {
            when {
                node == null -> return // number not found
                node.value > num -> remove(node, node.left, num)
                node.value < num -> remove(node, node.right, num)
                else -> { // number found
                    when {
                        node.left == null -> skipOverNode(parent, node, node.right)
                        node.right == null -> skipOverNode(parent, node, node.left)
                        else -> {
                            joinTrees(node.left!!, node.right!!)
                            skipOverNode(parent, node, node.left)
                        }
                    }
                }
            }
        }

        private fun skipOverNode(parent: TreeNode, node: TreeNode, child: TreeNode?) {
            when {
                parent.left == node -> parent.left = child
                parent.right == node -> parent.right = child
            }
        }

        private fun joinTrees(root1: TreeNode, root2: TreeNode) {
            var current = root1
            while (current.right != null) {
                current = current.right!!
            }
            current.right = root2
        }

        fun randomNode(): TreeNode? {
            if (root == null) {
                return null
            }
            val nodeArrayList = this.toArrayList()
            val randomIndex = Random().nextInt(nodeArrayList.size)
            return nodeArrayList[randomIndex]
        }

        private fun toArrayList(): ArrayList<TreeNode> {
            val result = arrayListOf<TreeNode>()
            fillArray(root, result)
            return result
        }

        private fun fillArray(root: TreeNode?, result: ArrayList<TreeNode>) {
            if (root != null) {
                result.add(root)
                fillArray(root.left, result)
                fillArray(root.right, result)
            }
        }
    }

    fun runTest() {
        val original = buildMinimalTree(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14))
        val tree = MyBST(original)
        tree.insert(15)
        TreeUtil.printBinaryTreeViaDepths(tree.root())
        tree.remove(15)
        TreeUtil.printBinaryTreeViaDepths(tree.root())
        tree.remove(14)
        TreeUtil.printBinaryTreeViaDepths(tree.root())
        val num = 10
        when (val node = tree.find(num)) {
            null -> println("[$num] not found\n")
            else -> println("node object id for [$num]: $node\n")
        }
        when (val node = tree.randomNode()) {
            null -> println("not found\n")
            else -> println("random node: ${node.value}\n")
        }
    }

    private fun buildMinimalTree(array: Array<Int>): TreeNode? {
        if (array.isEmpty()) {
            return null
        }

        val middleIndex = array.size / 2
        val root = TreeNode(array[middleIndex])

        root.left = buildMinimalTree(array.sliceArray(0 until middleIndex))
        root.right = buildMinimalTree(array.sliceArray(middleIndex + 1 until array.size))
        return root
    }
}