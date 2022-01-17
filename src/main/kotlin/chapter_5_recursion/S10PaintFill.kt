package chapter_5_recursion

import java.awt.Point

class S10PaintFill {
    private fun fill(screen: Array<IntArray>, p: Point, new: Int) {
        val old = screen[p.x][p.y]
        fillPaint(screen, p, old, new)
    }

    private fun fillPaint(screen: Array<IntArray>, p: Point, old: Int, new: Int) {
        if (!shouldFill(screen, p, old)) {
            return
        }

        screen[p.x][p.y] = new
        fillPaint(screen, Point(p.x - 1, p.y), old, new)
        fillPaint(screen, Point(p.x + 1, p.y), old, new)
        fillPaint(screen, Point(p.x, p.y - 1), old, new)
        fillPaint(screen, Point(p.x, p.y + 1), old, new)
    }

    private fun shouldFill(screen: Array<IntArray>, p: Point, old: Int): Boolean {
        return validLocation(p, screen) && screen[p.x][p.y] == old
    }

    private fun validLocation(p: Point, screen: Array<IntArray>): Boolean {
        return p.x >= 0 && p.x <= screen.lastIndex && p.y >= 0 && p.y <= screen[screen.lastIndex].lastIndex
    }

    private fun printScreen(screen: Array<IntArray>) {
        for (r in screen) {
            for (c in r) {
                print("$c ")
            }
            println()
        }
        println("----------------------------------------------")
    }

    class TestCase(
        val screen: Array<IntArray>,
        val startPoint: Point,
        val color: Int
    )

    private fun buildScreen(rows: Int, columns: Int, alreadyPainted: ArrayList<Point>): Array<IntArray> {
        val grid = Array(rows) { IntArray(columns) { 1 } }
        for (point in alreadyPainted) {
            when {
                point.x > grid.size || point.y >= grid[grid.lastIndex].size -> continue
                else -> grid[point.x][point.y] = 0
            }
        }
        return grid
    }

    private val screen1 = buildScreen(
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
    )

    private val screen2 = buildScreen(
        8, 8, arrayListOf(
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
            Point(5, 6),
            Point(5, 7),
            Point(6, 5),
            Point(7, 5),
        )
    )

    fun runTest() {
        val functions = arrayListOf(this::fill)
        val testCases = arrayListOf(
            TestCase(screen1, Point(0, 0), 2), //1 to 2
            TestCase(screen1, Point(0, 0), 1), //2 back to 1
            TestCase(screen1, Point(4, 4), 3), //1 to 3
            TestCase(screen2, Point(0, 0), 2), //1 to 2
            TestCase(screen2, Point(0, 0), 1), //2 back to 1
            TestCase(screen2, Point(4, 4), 3) //1 to 3

        )
        for (function in functions) {
            for ((i, case) in testCases.withIndex()) {
                println("Case #${i + 1}")
                println("========")
                val screen = case.screen
                val p = case.startPoint
                val c = case.color
                when {
                    !validLocation(p, screen) -> {
                        printScreen(screen)
                        println("Started outside the grid [${p.x}][${p.y}]")
                    }
                    else -> {
                        println("Before:")
                        printScreen(screen)
                        function(screen, p, c)
                        println("After:")
                        printScreen(screen)
                    }
                }
                println()
            }
        }
    }
}