package chapter_10_sorting_and_searching

import Util.Companion.sorted

class S2GroupAnagrams {
    /**
     * Runtime [average]: O(n * log(n))
     * Runtime [worst case]: O(n^2)
     * Memory: O(log(n))
     */
    private fun sort(array: Array<String>) {
        if (array.isNotEmpty()) {
            quickSort(array, 0, array.lastIndex)
        }
    }

    private fun quickSort(array: Array<String>, left: Int, right: Int) {
        val index = partition(array, left, right)
        if (left < index - 1) {
            quickSort(array, left, index - 1)
        }
        if (index < right) {
            quickSort(array, index, right)
        }
    }

    private fun partition(array: Array<String>, _left: Int, _right: Int): Int {
        var left = _left
        var right = _right

        val pivot = array[(left + right) / 2].sorted()
        while (left <= right) {
            while (array[left].sorted() < pivot) {
                left++
            }
            while (array[right].sorted() > pivot) {
                right--
            }
            if (left <= right) {
                Util.swap(array, left, right)
                left++
                right--
            }
        }
        return left
    }
    
    fun runTest() {
        val testCases = arrayListOf(
            arrayOf("hx", "test", "xh", "etts")
        )
        for (case in testCases) {
            println("before: ${Util.arrayAsString(case)}")
            sort(case)
            println("after: ${Util.arrayAsString(case)}")
            println("-----------------------------------------")
        }
    }
}