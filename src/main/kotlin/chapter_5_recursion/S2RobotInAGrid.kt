package chapter_5_recursion

import java.awt.Point

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

    private fun buildGrid(rows: Int, columns: Int, forbidden: ArrayList<Point>): Array<IntArray> {
            val grid = Array(rows) { IntArray(columns) { 1 } }
            for (tile in forbidden) {
                when {
                    tile.x > grid.size || tile.y >= grid[grid.lastIndex].size -> continue
                    else -> grid[tile.x][tile.y] = 0
                }
            }
            return grid
    }

    class TestCase(
        val grid: Array<IntArray>,
        val robotStartingPoint: Point
    )

    fun runTest() {
        val functions = arrayListOf(this::findPath)
        val testCases = arrayListOf(
            TestCase (buildGrid(5, 7, arrayListOf(
                    Point(0, 0),
                    Point(2, 1),
                    Point(1, 2),
                    Point(3, 3),
                    Point(4, 4)
                )),
                Point(0, 0)),
            TestCase(buildGrid(4, 4, arrayListOf(
                Point(0, 0),
                Point(2, 1),
                Point(1, 2)
            )),
                Point(0, 0))


        )
        for (function in functions) {
            for (case in testCases) {
                when (function(case.robotStartingPoint.x, case.robotStartingPoint.y, case.grid)) {
                    true -> println("Path found :)")
                    false -> println("No path found :(")
                }
                println()
            }
        }
    }
}