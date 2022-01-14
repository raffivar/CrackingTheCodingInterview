package chapter_5_recursion

import java.awt.Point

class S2RobotInAGrid {
    private fun findPath(grid: Array<IntArray>, p: Point): Boolean {
        printGrid(grid, p)
        if (!validLocation(p, grid)) {
            println("Robot started outside the grid!")
            return false
        }
        if (grid[p.x][p.y] == 0) {
            println("Robot started in forbidden point!")
            return false
        }
        if (isFinishLine(p, grid)) {
            return true
        }
        //attempt go down
        val nextX = p.x + 1
        if (nextX < grid.size && grid[nextX][p.y] == 1) {
            val result = findPath(grid, Point(nextX, p.y))
            if (result) {
                return result
            }
        }
        //attempt go right
        val nextY = p.y + 1
        if (nextY < grid[p.x].size && grid[p.x][nextY] == 1) {
            val result = findPath(grid, Point(p.x, nextY))
            if (result) {
                return result
            }
        }
        return false
    }

    private fun validLocation(p: Point, grid: Array<IntArray>): Boolean {
        return p.x >= 0 && p.x <= grid.lastIndex && p.y >= 0 && p.y <= grid[grid.lastIndex].lastIndex
    }

    private fun isFinishLine(p: Point, grid: Array<IntArray>): Boolean {
        return p.x == grid.lastIndex && p.y == grid[grid.lastIndex].lastIndex
    }

    private fun printGrid(grid: Array<IntArray>, p: Point) {
        for ((i, r) in grid.withIndex()) {
            for ((j, c) in r.withIndex()) {
                val value = when (p.x == i && p.y == j) { //is robot
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
            TestCase(
                buildGrid(
                    5, 7, arrayListOf(
                        Point(2, 1),
                        Point(1, 2),
                        Point(3, 3),
                        Point(4, 4)
                    )
                ),
                Point(0, 0)
            ),
            TestCase(
                buildGrid(
                    4, 4, arrayListOf(
                        Point(2, 1),
                        Point(1, 2)
                    )
                ),
                Point(0, 0)
            )
        )
        for (function in functions) {
            for (case in testCases) {
                when (function(case.grid, case.robotStartingPoint)) {
                    true -> println("Path found :)")
                    false -> println("No path found :(")
                }
                println()
            }
        }
    }
}