package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.trees.binary.Node
import chapter_4_trees_and_graphs.helpers.trees.TreeUtil
import com.sun.source.tree.Tree

class S11RandomNode {
    class MyBST {
        constructor()
        constructor(root: Node?) {
            this.root = root
        }

        private var root: Node? = null

        fun root(): Node? {
            return root
        }

        fun find(num: Int): Node? {
            return find(root, num)
        }

        private fun find(root: Node?, num: Int): Node? {
            return when {
                root == null -> null // num not found
                root.value > num -> find(root.left, num)
                root.value < num -> find(root.right, num)
                else -> root // num found
            }
        }

        fun insert(num: Int) {
            val node = Node(num)
            when (root) {
                null -> root = node
                else -> insert(root!!, node)
            }
        }

        private fun insert(root: Node, node: Node) {
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

        private fun remove(parent: Node, root: Node?, num: Int) {
            when {
                root == null -> return // number not found
                root.value > num -> remove(root, root.left, num)
                root.value < num -> remove(root, root.right, num)
                else -> { // number found
                    when {
                        root.left == null -> skipOverNode(parent, root, root.right)
                        root.right == null -> skipOverNode(parent, root, root.left)
                        else -> {
                            joinTrees(root.left!!, root.right!!)
                            skipOverNode(parent, root, root.left)
                        }
                    }
                }
            }
        }

        private fun skipOverNode(parent: Node, node: Node, child: Node?) {
            when {
                parent.left == node -> parent.left = child
                parent.right == node -> parent.right = child
            }
        }

        private fun joinTrees(root1: Node, root2: Node) {
            var current = root1
            while (current.right != null) {
                current = current.right!!
            }
            current.right = root2
        }
    }

    fun runTest() {
        val original = buildMinimalTree(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14))
        val tree = MyBST(original)
        tree.insert(15)
        TreeUtil.printBinaryTreeViaDepths(tree.root())
        tree.remove(4)
        TreeUtil.printBinaryTreeViaDepths(tree.root())
        val result = tree.find(14)
        TreeUtil.printBinaryTreeViaDepths(result)
    }

    private fun buildMinimalTree(array: Array<Int>): Node? {
        if (array.isEmpty()) {
            return null
        }

        val middleIndex = array.size / 2
        val root = Node(array[middleIndex])

        root.left = buildMinimalTree(array.sliceArray(0 until middleIndex))
        root.right = buildMinimalTree(array.sliceArray(middleIndex + 1 until array.size))
        return root
    }
}