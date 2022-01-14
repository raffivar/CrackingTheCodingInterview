package chapter_5_recursion

import java.awt.Point

class S2RobotInAGrid {
    private fun findPath(grid: Array<IntArray>, p: Point): Boolean {
        printGrid(p, grid)
        if (isFinishLine(p, grid)) {
            return true
        }
        //attempt go down
        val nextX = p.x + 1
        if (nextX < grid.size && grid[nextX][p.y] == 1 && findPath(grid, Point(nextX, p.y))) {
            return true
        }
        //attempt go right
        val nextY = p.y + 1
        if (nextY < grid[p.x].size && grid[p.x][nextY] == 1 && findPath(grid, Point(p.x, nextY))) {
            return true
        }
        return false
    }

    private fun validLocation(p: Point, grid: Array<IntArray>): Boolean {
        return p.x >= 0 && p.x <= grid.lastIndex && p.y >= 0 && p.y <= grid[grid.lastIndex].lastIndex
    }

    private fun isFinishLine(p: Point, grid: Array<IntArray>): Boolean {
        return p.x == grid.lastIndex && p.y == grid[grid.lastIndex].lastIndex
    }

    private fun printGrid(p: Point, grid: Array<IntArray>) {
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
        println("----------------------------------------------")
    }

    private fun buildGrid(rows: Int, columns: Int, forbiddenPoints: ArrayList<Point>): Array<IntArray> {
        val grid = Array(rows) { IntArray(columns) { 1 } }
        for (point in forbiddenPoints) {
            when {
                point.x > grid.size || point.y >= grid[grid.lastIndex].size -> continue
                else -> grid[point.x][point.y] = 0
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
                        Point(1, 2),
                        Point(2, 3),
                        Point(3, 2),
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
                Point(1, 2)
            ),
            TestCase(
                buildGrid(
                    4, 4, arrayListOf(
                        Point(2, 1),
                        Point(1, 2)
                    )
                ),
                Point(6, 7)
            )
        )
        for (function in functions) {
            for ((i, case) in testCases.withIndex()) {
                println("case #${i + 1}")
                println("========")
                val grid = case.grid
                val p = case.robotStartingPoint
                when {
                    !validLocation(p, grid) -> {
                        printGrid(p, grid)
                        println("Robot started outside the grid! [${p.x}][${p.y}]")
                    }
                    grid[p.x][p.y] == 0 -> {
                        printGrid(p, grid)
                        println("Robot started in forbidden point!")
                    }
                    else -> {
                        when (function(grid, p)) {
                            true -> println("Path found :)")
                            false -> println("No path found :(")
                        }
                    }
                }
                println()
            }
        }
    }
}