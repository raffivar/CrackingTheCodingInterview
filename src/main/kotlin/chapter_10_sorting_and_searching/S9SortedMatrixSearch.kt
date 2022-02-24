package chapter_10_sorting_and_searching

import Solution
import chapter_10_sorting_and_searching.searching.Searching
import java.awt.Point

class S9SortedMatrixSearch : Solution {
    private fun findInMatrix(matrix: Array<IntArray>, num: Int): Point {
        var low = 0
        var high = matrix.lastIndex
        var mid: Int

        while (low <= high) {
            mid = (low + high) / 2
            val midArray = matrix[mid]
            when {
                midArray[0] > num -> high = mid - 1
                midArray[midArray.lastIndex] < num -> low = mid + 1
                else -> return Point(mid, Searching.binarySearch(matrix[mid], num))
            }
        }

        return Point(-1, -1)
    }

    override fun runTest() {
        val example = arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(6, 7, 8, 9, 10),
            intArrayOf(11, 12, 13, 14, 15),
            intArrayOf(16, 17, 18, 19, 20),
        )
        val testCases = arrayListOf(
            Pair(example, 2),
            Pair(example, 13),
            Pair(example, 20),
            Pair(example, 25)
        )

        for (case in testCases) {
            println("Searching for [${case.second}] in:\n${Util.matrixAsString(case.first)}")
            val result = findInMatrix(case.first, case.second)
            when {
                result.x == -1 || result.y == -1 -> println("Not found")
                else -> println("Found in index [${result.x}, ${result.y}]")
            }
            println("-----------------------------------------------------------------------")
        }
    }
}