package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.graphs.GraphBuilder
import chapter_4_trees_and_graphs.helpers.graphs.Node

class S0AreTwoNodesConnected {
    private fun routeBetweenNodes(root: Node, node1: Node, node2: Node): Boolean {
        root.visited = true
        for (child in root.children!!) {
            if (child != null) {
                if (haveRoute(root, child, node1, node2)) {
                    return true
                }
                if (!child.visited && routeBetweenNodes(child, node1, node2)) {
                    return true
                }
            }
        }
        return false
    }

    private fun haveRoute(testNode1: Node, testNode2: Node, node1: Node, node2: Node): Boolean {
        return (testNode1 == node1 && testNode2 == node2) || (testNode1 == node2 && testNode2 == node1)
    }

    fun runTest() {
        val graph = GraphBuilder.Graph()
        val root = graph.build()
        printResult(root, graph.nodes[3], graph.nodes[2])
        graph.reset()
        printResult(root, graph.nodes[0], graph.nodes[1])
        graph.reset()
        printResult(root, graph.nodes[4], graph.nodes[3])
        graph.reset()
        printResult(root, graph.nodes[5], graph.nodes[4])
        graph.reset()
        printResult(root, graph.nodes[2], graph.nodes[4])
    }

    private fun printResult(root: Node, node1: Node, node2: Node) {
        println("From ${node1.value} and ${node2.value} -> ${routeBetweenNodes(root, node1, node2)}")
    }
}