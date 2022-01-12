package chapter_5_recursion

class S2RobotInAGrid {
    fun isPath(): Boolean {
        return false
    }

    class Robot {
        var x = 0
        var y = 0
    }

    private val r = 5
    private val c = 7
    private val grid = Array(r) { IntArray(c) { 1 } }
    private val robot = Robot()

    private fun buildGrid() {
        val forbidden = arrayListOf(
            Pair(0, 0),
            Pair(2, 1),
            Pair(1, 2),
            Pair(3, 3),
            Pair(4, 4)
        )

        for (tile in forbidden) {
            when {
                tile.first == robot.x && tile.second == robot.y -> continue //cannot forbid starting point of robot
                tile.first >= r || tile.second >= c -> continue
                else -> grid[tile.first][tile.second] = 0
            }
        }
    }

    private fun printGrid() {
        for ((i, r) in grid.withIndex()) {
            for ((j, c) in r.withIndex()) {
                val value = when (isRobot(i, j)) {
                    true -> "R"
                    false -> c
                }
                print("$value ")
            }
            println()
        }
    }

    private fun isRobot(r: Int, c: Int): Boolean {
        return robot.x == r && robot.y == c
    }

    fun runTest() {
        buildGrid()
        val functions = arrayListOf(this::printGrid)
        val testCases = arrayListOf(1)
        for (function in functions) {
            for (case in testCases) {
                function()
            }
        }
    }
}