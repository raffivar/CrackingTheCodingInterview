package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.graphs.GraphBuilder
import chapter_4_trees_and_graphs.helpers.graphs.Node

class S1RouteBetweenNodes {
    private fun routeBetweenNodes(node1: Node, node2: Node): Boolean {
        val children = node1.children ?: return false
        for (child in children) {
            if (child == node2) {
                return true
            }
            child!!.visited = true
            if (!child.visited && routeBetweenNodes(child, node2)) {
                return true
            }
        }
        return false
    }

    fun runTest() {
        val graph = GraphBuilder.Graph()
        printResult(graph.nodes[3], graph.nodes[2])
        printResult(graph.nodes[0], graph.nodes[1])
        printResult(graph.nodes[3], graph.nodes[4])
        printResult(graph.nodes[0], graph.nodes[4])
        printResult(graph.nodes[4], graph.nodes[3])
        printResult(graph.nodes[5], graph.nodes[4])
        printResult(graph.nodes[2], graph.nodes[4])
    }

    private fun printResult(node1: Node, node2: Node) {
        println("From ${node1.value} and ${node2.value} -> ${routeBetweenNodes(node1, node2)}")
    }
}