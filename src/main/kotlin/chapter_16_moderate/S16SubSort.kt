package chapter_16_moderate

class S16SubSort {
    private fun getSubSortIndices(array: IntArray): Pair<Int, Int> {
        var i = 0
        var j = array.lastIndex

        var left = -1
        var right = -1

        while (i <= j && (left == -1 || right == -1)) {
            when (left == -1 && array[i + 1] < array[i]) {
                true -> left = i + 1
                false -> i++
            }
            when (right == -1 && array[j - 1] > array[j]) {
                true -> right = j - 1
                false -> j--
            }
        }

        var low = 0
        while (low < left && array[low] <= array[left]) {
            low++
        }

        var high = array.lastIndex
        while (high > right && array[high] >= array[right]) {
            high--
        }

        return Pair(low, high)
    }

    fun runTest() {
        val testCases = arrayListOf(intArrayOf(1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19))
        for (case in testCases) {
            println(Util.arrayAsString(case))
            val result = getSubSortIndices(case)
            println("[${result.first}, ${result.second}]")
        }
    }
}