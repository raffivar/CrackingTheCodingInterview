package chapter_10_sorting_and_searching.searching

class BinarySearch {
    private fun binarySearch(array: IntArray, num: Int): Int {
        var low = 0
        var high = array.lastIndex
        var mid: Int

        while (low <= high) {
            mid = (low + high) / 2
            when {
                array[mid] < num -> low = mid + 1
                array[mid] > num -> high = mid - 1
                else -> return mid
            }
        }

        return -1
    }

    fun search() {
        val testCases = arrayListOf(
            Pair(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3),
            Pair(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 6),
            Pair(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 15)
        )

        for (case in testCases) {
            when (val index = binarySearch(case.first, case.second)) {
                -1 -> println("index of ${case.second} in array is: $index [Not found]")
                else -> println("index of ${case.second} in array is: $index")
            }
        }
    }
}