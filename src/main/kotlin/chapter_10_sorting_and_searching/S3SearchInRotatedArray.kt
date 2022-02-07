package chapter_10_sorting_and_searching

class S3SearchInRotatedArray {
    private fun search(array: IntArray, num: Int): Int {
        val minIndex = findMin(array)
        return when (num > array[array.lastIndex]) {
            true -> binarySearch(array, num, 0, minIndex - 1)
            false -> binarySearch(array, num, minIndex, array.lastIndex)
        }
    }

    private fun findMin(array: IntArray): Int {
        if (array.isEmpty()) {
            return -1
        }
        var minIndex = 0
        for (i in array.indices) {
            if (array[i] < array[minIndex]) {
                minIndex = i
            }
        }
        return minIndex
    }

    private fun binarySearch(array: IntArray, num: Int, _low: Int, _high: Int): Int {
        var low = _low
        var high = _high
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

    fun runTest() {
        val mainExample = intArrayOf(15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14)
        val testCases = arrayListOf(
            Pair(mainExample, 19),
            Pair(mainExample, 14),
            Pair(mainExample, 1),
            Pair(mainExample, 25),
            Pair(mainExample, 15)
        )

        for (case in testCases) {
            println("Searching for [${case.second}] in ${Util.arrayAsString(case.first)}")
            when (val result = search(case.first, case.second)) {
                -1 -> println("Not found")
                else -> println("Found in index [$result]")
            }
        }
    }
}