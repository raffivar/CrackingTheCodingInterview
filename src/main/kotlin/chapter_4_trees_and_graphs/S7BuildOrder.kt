package chapter_4_trees_and_graphs

import chapter_4_trees_and_graphs.helpers.trees.TreeWithParentsUtil
import chapter_4_trees_and_graphs.helpers.trees.binary.NodeWithParent

class S7BuildOrder {
    private class Project(
        val name: Char,
        val children: MutableList<Project> = mutableListOf()
    )

    private val a = Project('a')
    private val b = Project('b')
    private val c = Project('c')
    private val d = Project('d')
    private val e = Project('e')
    private val f = Project('f')

    fun runTest() {
        val projects = listOf(a, b, c, d, e, f)
        val dependencies = listOf(
            Pair(a, d),
            Pair(f, b),
            Pair(b, d),
            Pair(f, a),
            Pair(d, c),
        )

        val orderedList = buildOrder(projects, dependencies)
    }

    private fun buildOrder(projects: List<Project>, dependencies: List<Pair<Project, Project>>): List<Project> {
        val ordered = mutableListOf<Project>()
        for (dependency in dependencies) {
            dependency.first.children.add(dependency.second)
        }
        return ordered
    }


}