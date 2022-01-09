package chapter_4_trees_and_graphs.helpers

object GraphBuilder {
    /**
     * 0 -> 1 <- 2
     * | \  |    ^
     * v  v v    |
     * 5    4 <- 3
     */
    class Graph {
        fun build(): Node {
            return nodes[0]
        }

        fun reset() {
            for (node in nodes) {
                node.visited = false
            }
        }

        val nodes = arrayOf(
            Node(0),
            Node(1),
            Node(2),
            Node(3),
            Node(4),
            Node(5))

        init {
            nodes[0].children = arrayOf(nodes[1], nodes[4], nodes[5])
            nodes[1].children = arrayOf(nodes[3], nodes[4])
            nodes[2].children = arrayOf(nodes[1])
            nodes[3].children = arrayOf(nodes[2], nodes[4])
            nodes[4].children = arrayOf()
            nodes[5].children = arrayOf()
        }

    }
}