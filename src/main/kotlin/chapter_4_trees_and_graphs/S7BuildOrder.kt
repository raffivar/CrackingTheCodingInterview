package chapter_4_trees_and_graphs

class S7BuildOrder {
    private class Project(
        val name: Char,
        val children: MutableList<Project> = mutableListOf(),
        var visited: Boolean = false
    )

    private class ProjectNode(
        val project: Project,
        var next: ProjectNode?
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

        var current = buildOrder(projects, dependencies)
        while (current != null) {
            print("${current.project.name} -> ")
            current = current.next
        }
        println("||")
    }

    private fun buildOrder(projects: List<Project>, dependencies: List<Pair<Project, Project>>): ProjectNode? {
        // build graph
        for (dependency in dependencies) {
            dependency.first.children.add(dependency.second)
        }

        // check graph validity
        when (validate(projects)) {
            true -> println("Graph is valid")
            false -> {
                println("Invalid graph, please take care of")
                return null
            }
        }

        // build order
        var head: ProjectNode? = null
        for (project in projects) {
            val projectNode = ProjectNode(project, null)
            var previous: ProjectNode? = null
            var current = head
            while (current != null && !isDependant(project, current.project)) {
                previous = current
                current = current.next
            }
            when (current) {
                head -> { //beginning
                    projectNode.next = current
                    head = projectNode
                }
                else -> { //middle or end
                    projectNode.next = current
                    previous!!.next = projectNode
                }
            }
        }

        return head
    }

    private fun isDependant(project1: Project, project2: Project): Boolean {
        return project1.children.contains(project2)
    }

    private fun validate(projects: List<Project>): Boolean {
        var isValid = true
        for (project in projects) {
            if (routeBetweenNodes(project, project)) {
                println("Project ${project.name} - Corrupted (found loop)")
                isValid = false
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