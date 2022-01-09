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
            Node(value = 0),
            Node(value = 1),
            Node(value = 2),
            Node(value = 3),
            Node(value = 4),
            Node(value = 5))

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