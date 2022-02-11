package chapter_10_sorting_and_searching

class S11PeaksAndValleys {
    private fun peaksAndValleys(array: IntArray) {
        var i = 0
        while (i < array.lastIndex - 1) {
            when {
                i % 2 == 0 && array[i] < array[i + 1] -> Util.swap(array, i, i + 1)
                i % 2 != 0 && array[i] > array[i + 1] -> Util.swap(array, i, i + 1)
            }
            i++
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