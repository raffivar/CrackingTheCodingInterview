package chapter_16_moderate

class S16SubSort {
    private fun getSubSortIndices(array: IntArray): Pair<Int, Int>? {
        //Search first anomaly from the left
        var leftAnomalyIndex = 0
        while (leftAnomalyIndex < array.lastIndex && array[leftAnomalyIndex + 1] > array[leftAnomalyIndex]) {
            leftAnomalyIndex++
        }

        //Determine if anomaly found
        when (leftAnomalyIndex == array.lastIndex) {
            true -> return null //Anomaly not found
            false -> leftAnomalyIndex++ //Anomaly found
        }

        //Search first anomaly from the right
        var rightAnomalyIndex = array.lastIndex
        while (array[rightAnomalyIndex - 1] < array[rightAnomalyIndex]) { //Will stop when getting to left anomaly
            rightAnomalyIndex--
        }
        rightAnomalyIndex--

        //Find closet element from below to left anomaly
        var left = 0
        while (array[left] < array[leftAnomalyIndex]) {
            left++
        }

        //find closest element from above to right anomaly
        var right = array.lastIndex
        while (array[right] > array[rightAnomalyIndex]) {
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