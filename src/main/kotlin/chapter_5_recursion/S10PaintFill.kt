package chapter_5_recursion

import java.awt.Point

class S10PaintFill {
    private fun fill(grid: Array<IntArray>, p: Point, new: Int) {
        val old = grid[p.x][p.y]
        fillPaint(grid, p, old, new)
    }

    private fun fillPaint(grid: Array<IntArray>, p: Point, old: Int, new: Int) {
        grid[p.x][p.y] = new

        val top = Point(p.x - 1, p.y)
        if (shouldFill(grid, top, old)) {
            fillPaint(grid, top, old, new)
        }

        val bottom = Point(p.x + 1, p.y)
        if (shouldFill(grid, bottom, old)) {
            fillPaint(grid, bottom, old, new)
        }

        val left = Point(p.x, p.y - 1)
        if (shouldFill(grid, left, old)) {
            fillPaint(grid, left, old, new)
        }

        val right = Point(p.x, p.y + 1)
        if (shouldFill(grid, right, old)) {
            fillPaint(grid, right, old, new)
        }
    }

    private fun shouldFill(grid: Array<IntArray>, p: Point, old: Int): Boolean {
        return validLocation(p, grid) && grid[p.x][p.y] == old
    }

    private fun validLocation(p: Point, grid: Array<IntArray>): Boolean {
        return p.x >= 0 && p.x <= grid.lastIndex && p.y >= 0 && p.y <= grid[grid.lastIndex].lastIndex
    }

    private fun printGrid(p: Point, grid: Array<IntArray>) {
        for (r in grid) {
            for (c in r) {
                print("$c ")
            }
            println()
        }
        println("----------------------------------------------")
    }

    class TestCase(
        val grid: Array<IntArray>,
        val startPoint: Point,
        val color: Int
    )

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

    fun runTest() {
        val functions = arrayListOf(this::fill)
        val testCases = arrayListOf(
            TestCase(
                buildGrid(
                    7, 7, arrayListOf(
                        Point(1, 1),
                        Point(1, 2),
                        Point(1, 3),
                        Point(1, 4),
                        Point(1, 5),
                        Point(1, 1),
                        Point(2, 1),
                        Point(3, 1),
                        Point(4, 1),
                        Point(5, 1),
                        Point(5, 2),
                        Point(5, 3),
                        Point(5, 4),
                        Point(5, 5),
                        Point(1, 5),
                        Point(2, 5),
                        Point(3, 5),
                        Point(4, 5),
                        Point(5, 5),
                    )
                ),
                Point(0, 0),
                3
            )
        )
        for (function in functions) {
            for ((i, case) in testCases.withIndex()) {
                println("Case #${i + 1}")
                println("========")
                val grid = case.grid
                val p = case.startPoint
                val c = case.color
                when {
                    !validLocation(p, grid) -> {
                        printGrid(p, grid)
                        println("Started outside the grid [${p.x}][${p.y}]")
                    }
                    else -> {
                        println("Before:")
                        printGrid(p, grid)
                        function(grid, p, c)
                        println("After:")
                        printGrid(p, grid)
                    }
                }
                println()
            }
        }
    }
}