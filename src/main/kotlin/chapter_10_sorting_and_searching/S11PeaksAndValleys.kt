package chapter_10_sorting_and_searching

import chapter_10_sorting_and_searching.sorting.Sorting

class S11PeaksAndValleys {
    private fun peaksAndValleys(array: IntArray) {
        Sorting.quickSort(array)
        val result = IntArray(array.size)
        var k = 0
        var i = 0
        var j = array.lastIndex
        while (i <= j) {
            result[k] = array[j]
            if (k < array.lastIndex) {
                result[k + 1] = array[i]
            }
            k += 2
            i++
            j--
        }
        copyArray(array, result)
    }

    private fun copyArray(dest: IntArray, src: IntArray) {
        for (i in 0..dest.lastIndex) {
            dest[i] = src[i]
        }
    }

    fun runTest() {
        val testCases = arrayListOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(1, 2, 3, 4, 5, 6)
        )
        for (case in testCases) {
            println("before: ${Util.arrayAsString(case)}")
            peaksAndValleys(case)
            println("after: ${Util.arrayAsString(case)}")
            println("-----------------------------------------")
        }
    }
}