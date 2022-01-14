package chapter_5_recursion

class S2RobotInAGrid {
    private fun findPath(curDown: Int, curRight: Int, grid: Array<IntArray>): Boolean {
        printGrid(curDown, curRight, grid)
        if (!validLocation(curDown, curRight, grid)) {
            println("Robot is outside the grid")
            return false
        }
        if (isFinishLine(curDown, curRight, grid)) {
            return true
        }
        //attempt go down
        val nextDown = curDown + 1
        if (nextDown < grid.size && grid[nextDown][curRight] == 1) {
            val result = findPath(nextDown, curRight, grid)
            if (result) {
                return result
            }
        }
        //attempt go right
        val nextRight = curRight + 1
        if (nextRight < grid[curDown].size && grid[curDown][nextRight] == 1) {
            val result = findPath(curDown, nextRight, grid)
            if (result) {
                return result
            }
        }
        return false
    }

    private fun validLocation(x: Int, y: Int, grid: Array<IntArray>): Boolean {
        return x >= 0 && x <= grid.lastIndex && y >= 0 && y <= grid[grid.lastIndex].lastIndex
    }

    private fun isFinishLine(x: Int, y: Int, grid: Array<IntArray>): Boolean {
        return x == grid.lastIndex && y == grid[grid.lastIndex].lastIndex
    }

    private fun printGrid(curRow: Int, curColumn: Int, grid: Array<IntArray>) {
        for ((i, r) in grid.withIndex()) {
            for ((j, c) in r.withIndex()) {
                val value = when (curRow == i && curColumn == j) { //is robot
                    true -> "R"
                    false -> c
                }
                print("$value ")
            }
            println()
        }
        println("================================================")
    }

    class Grid(
        val robotStartRow: Int,
        val robotStartColumn: Int,
        private val rows: Int,
        private val columns: Int,
        private val forbidden: ArrayList<Pair<Int, Int>>) {
        fun build(): Array<IntArray> {
            val grid = Array(rows) { IntArray(columns) { 1 } }
            for (tile in forbidden) {
                when {
                    tile.first == robotStartRow && tile.second == robotStartColumn -> continue //cannot forbid starting point of robot
                    tile.first > grid.size || tile.second >= grid[grid.lastIndex].size -> continue
                    else -> grid[tile.first][tile.second] = 0
                }
            }
            return grid
        }
    }

    fun runTest() {
        val functions = arrayListOf(this::findPath)
        val testCases = arrayListOf(
            Grid(0, 0, 5, 7, arrayListOf(
                    Pair(0, 0),
                    Pair(2, 1),
                    Pair(1, 2),
                    Pair(3, 3),
                    Pair(4, 4)
                )
            ),
            Grid(0, 0, 4, 4, arrayListOf(
                    Pair(0, 0),
                    Pair(2, 1),
                    Pair(1, 2)
                )
            )
        )
        for (function in functions) {
            for (case in testCases) {
                when (function(case.robotStartRow, case.robotStartColumn, case.build())) {
                    true -> println("Path found :)")
                    false -> println("No path found :(")
                }
                println()
            }
        }
    }
}