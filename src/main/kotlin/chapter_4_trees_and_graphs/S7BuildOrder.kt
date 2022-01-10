package chapter_4_trees_and_graphs

class S7BuildOrder {
    private class Project(
        val name: Char,
        val children: MutableList<Project> = mutableListOf(),
        var visited: Boolean = false
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
        // build graph
        for (dependency in dependencies) {
            dependency.first.children.add(dependency.second)
        }

        val ordered = mutableListOf<Project>()

        // check graph validity
        when (validate(projects)) {
            true -> println("Graph is valid")
            false -> {
                println("Invalid graph, please take care of")
                return ordered
            }
        }

        return ordered
    }

    private fun validate(projects: List<Project>): Boolean {
        var isValid = true
        for (project in projects) {
            if (routeBetweenNodes(project, project)) {
                println("Project ${project.name} - Corrupted (found loop)")
                isValid =  false
            } else {
                println("Project ${project.name} - OK (no loop)")
            }
            resetVisited(projects)
        }
        println("---------------------------------------------------------------")
        return isValid
    }

    private fun routeBetweenNodes(node1: Project, node2: Project): Boolean {
        val children = node1.children
        for (child in children) {
            if (child == node2) {
                return true
            }
            if (!child.visited) {
                child.visited = true
                if (routeBetweenNodes(child, node2)) {
                    return true
                }
            }
        }
        return false
    }

    private fun resetVisited(projects: List<Project>) {
        for (project in projects) {
            project.visited = false
        }
    }
}