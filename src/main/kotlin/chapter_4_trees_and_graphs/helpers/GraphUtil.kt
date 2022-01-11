package chapter_4_trees_and_graphs.helpers

object GraphUtil {
    /**
     * 0 -> 1 <- 2
     * | \  |    ^
     * v  v v    |
     * 5    4 <- 3
     */
    class Graph {
        fun resetVisited() {
            for (node in nodes) {
                node.visited = false
            }
        }

        val nodes = arrayOf(
            GraphNode(0),
            GraphNode(1),
            GraphNode(2),
            GraphNode(3),
            GraphNode(4),
            GraphNode(5)
        )

        init {
            nodes[0].children = arrayOf(nodes[1], nodes[4], nodes[5])
            nodes[1].children = arrayOf(nodes[3], nodes[4])
            nodes[2].children = arrayOf(nodes[1])
            nodes[3].children = arrayOf(nodes[2], nodes[4])
        }
    }
}