package chapter_10_sorting_and_searching.sorting_algorithms


class QuickSort {
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

    fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

    fun runTest() {
        for (case in Sorting.testCases) {
            quickSort(case, 0, case.size - 1)
            Sorting.print(case)
        }
    }
}