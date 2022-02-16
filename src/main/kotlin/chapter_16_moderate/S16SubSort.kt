package chapter_16_moderate

class S16SubSort {
    private fun getSubSortIndices(array: IntArray): Pair<Int, Int>? {
        //Search first anomaly from the left
        var i = 0
        while (i < array.lastIndex && array[i + 1] > array[i]) {
            i++
        }

        //Determine if anomaly found
        when (i == array.lastIndex) {
            true -> return null //Anomaly not found
            false -> i++ //Anomaly found
        }

        //Search first anomaly from the right
        var j = array.lastIndex
        while (array[j - 1] < array[j]) { //Will stop when getting to left anomaly
            j--
        }
        j--

        //Find closet element from below
        var left = 0
        while (array[left] < array[i]) {
            left++
        }

        //find closest element from above
        var right = array.lastIndex
        while (array[right] > array[j]) {
            right--
        }

        return Pair(left, right)
    }

    fun runTest() {
        val testCases = arrayListOf(
            intArrayOf(1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19),
            intArrayOf(11, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19),
            intArrayOf(10, 11, 7, 12, 6, 7),
            intArrayOf(1, 2, 12, 7),
            intArrayOf(1, 2, 12, 7, 8, 9, 10),
            intArrayOf(1, 2, 4, 7)
        )
        for (case in testCases) {
            println(Util.arrayAsString(case))
            when (val result = getSubSortIndices(case)) {
                null -> println("No need for sub-sorting :)")
                else -> println("[${result.first}, ${result.second}]\n")
            }

        }
    }
}