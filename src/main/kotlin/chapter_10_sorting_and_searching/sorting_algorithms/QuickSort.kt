package chapter_10_sorting_and_searching.sorting_algorithms


class QuickSort {
    /**
     * Runtime [average]: O(n * log(n))
     * Runtime [worst case]: O(n^2)
     * Memory: O(n * log(n))
     */

    private fun quickSort(arr: IntArray, left: Int, right: Int) {
        val index = partition(arr, left, right)
        if (left < index - 1) {
            quickSort(arr, left, index - 1)
        }
        if (index < right) {
            quickSort(arr, index, right)
        }
    }

    private fun partition(arr: IntArray, _left: Int, _right: Int): Int {
        var left = _left
        var right = _right

        val pivot = arr[(left + right) / 2]
        while (left <= right) {
            while (arr[left] < pivot) {
                left++
            }
            while (arr[right] > pivot) {
                right--
            }
            if (left <= right) {
                swap(arr, left, right)
                left++
                right--
            }
        }
        return left
    }

    private fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

    fun sort(testCases: ArrayList<IntArray>) {
        for (case in testCases) {
            quickSort(case, 0, case.lastIndex)
            Sorting.print(case)
        }
    }
}