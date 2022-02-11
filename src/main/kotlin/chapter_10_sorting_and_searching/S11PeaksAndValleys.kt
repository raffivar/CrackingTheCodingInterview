package chapter_10_sorting_and_searching

import chapter_10_sorting_and_searching.sorting.Sorting

class S11PeaksAndValleys {
    private fun peaksAndValleys(array: IntArray) {
        Sorting.quickSort(array)
        val n = when (array.size % 2) {
            0 -> array.lastIndex
            else -> array.lastIndex - 1
        }
        var i = 0
        while (i < n) {
            Util.swap(array, i, i + 1)
            i += 2
        }
    }

    fun runTest() {
        val testCases = arrayListOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(1, 2, 3, 4, 5, 6),
            intArrayOf(5, 3, 1, 2, 3)
        )
        for (case in testCases) {
            println("before: ${Util.arrayAsString(case)}")
            peaksAndValleys(case)
            println("after: ${Util.arrayAsString(case)}")
            println("-----------------------------------------")
        }
    }
}