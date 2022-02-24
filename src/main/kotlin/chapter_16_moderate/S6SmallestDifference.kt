package chapter_16_moderate

import Solution
import chapter_10_sorting_and_searching.sorting.Sorting
import kotlin.math.abs

class S6SmallestDifference : Solution {
    private fun countFactZeros(a1: IntArray, a2: IntArray): Int {
        Sorting.sort(a1)
        Sorting.sort(a2)
        var i = 0
        var j = 0
        var difference = Int.MAX_VALUE
        while (i < a1.size && j < a2.size) {
            val diff = abs(a1[i] - a2[j])
            if (diff < difference) {
                difference = diff
            }
            when (a1[i] < a2[j]) {
                true -> i++
                false -> j++
            }
        }
        return difference
    }

    override fun runTest() {
        val testCases = arrayListOf(
            Pair(
                intArrayOf(1, 3, 15, 11, 2),
                intArrayOf(23, 127, 235, 19, 8)
            ),
            Pair(
                intArrayOf(1, 2, 11, 15),
                intArrayOf(4, 12, 19, 23, 127, 235)
            )
        )
        for (case in testCases) {
            println(
                "${Util.arrayAsString(case.first)}\n" +
                        "${Util.arrayAsString(case.second)}\n" +
                        "${countFactZeros(case.first, case.second)}"
            )
        }
    }
}