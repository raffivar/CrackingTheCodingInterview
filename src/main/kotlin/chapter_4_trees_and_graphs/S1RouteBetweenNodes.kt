package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.GraphUtil
import chapter_4_trees_and_graphs.helpers.GraphNode

class S1RouteBetweenNodes {
    private fun routeBetweenNodes(node1: GraphNode, node2: GraphNode): Boolean {
        val children = node1.children ?: return false
        for (child in children) {
            if (child == node2) {
                return true
            }
            if (!child!!.visited) {
                child.visited = true
                if (routeBetweenNodes(child, node2)) {
                    return true
                }
            }
        }
        return false
    }

    fun runTest() {
        val graph = GraphUtil.Graph()
        val functions = arrayListOf(this::routeBetweenNodes)
        val testCases = arrayListOf(
            Pair(graph.nodes[3], graph.nodes[2]),
            Pair(graph.nodes[0], graph.nodes[1]),
            Pair(graph.nodes[3], graph.nodes[4]),
            Pair(graph.nodes[0], graph.nodes[4]),
            Pair(graph.nodes[4], graph.nodes[3]),
            Pair(graph.nodes[5], graph.nodes[4]),
            Pair(graph.nodes[2], graph.nodes[4])
        )

        for (function in functions) {
            for (testCase in testCases) {
                println("${testCase.first.value} -> ${testCase.second.value} -> ${function(testCase.first, testCase.second)}")
                graph.resetVisited()
            }
        }
    }
}