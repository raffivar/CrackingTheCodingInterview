package chapter_16_moderate

import Util.Companion.asString
import java.awt.Point

class S19PondSizes {
    private fun getPondSizes(land: Array<IntArray>): ArrayList<Int> {
        val pondSizes = ArrayList<Int>()
        val pondsVisited = HashSet<Point>()
        for (i in land.indices) {
            for (j in land[i].indices) {
                val pondSize = calcPondSize(land, pondsVisited, i, j)
                if (pondSize > 0) {
                    pondSizes.add(pondSize)
                }
            }
        }
        return pondSizes
    }

    private fun calcPondSize(land: Array<IntArray>, visited: HashSet<Point>, i: Int, j: Int): Int {
        if (land[i][j] != 0 || visited.contains(Point(i, j))) {
            return 0
        }
        var pondSize = 1
        visited.add(Point(i, j))
        for (m in i - 1..i + 1) {
            for (n in j - 1..j + 1) {
                if (m in 0..land.lastIndex && n in 0..land.lastIndex && (m != i || n != j)) {
                    pondSize += calcPondSize(land, visited, m, n)
                }
            }
        }
        return pondSize
    }

    fun runTest() {
        val land = arrayOf(
            intArrayOf(0, 2, 1, 0),
            intArrayOf(0, 1, 0, 1),
            intArrayOf(1, 1, 0, 1),
            intArrayOf(0, 1, 0, 1)
        )

        println("land:\n${Util.matrixAsString(land)}")
        println("pond sizes: ${getPondSizes(land).asString()}")
    }
}