package chapter_10_sorting_and_searching.sorting_algorithms

class MergeSort {
    private fun mergeSort(array: IntArray) {
        val helper = IntArray(array.size)
        mergeSort(array, helper, 0, array.lastIndex)
    }

    private fun mergeSort(array: IntArray, helper: IntArray, low: Int, high: Int) {
        if (low < high) {
            val middle = (low + high) / 2
            mergeSort(array, helper, low, middle)
            mergeSort(array, helper, middle + 1, high)
            merge(array, helper, low, middle, high)
        }
    }

    private fun merge(array: IntArray, helper: IntArray, low: Int, middle: Int, high: Int) {
        for (i in low..high) {
            helper[i] = array[i]
        }

        var helperLeft = low
        var helperRight = middle + 1
        var current = low

        while (helperLeft <= middle && helperRight <= high) {
            when (helper[helperLeft] <= helper[helperRight]) {
                true -> {
                    array[current] = helper[helperLeft]
                    helperLeft++
                }
                false -> {
                    array[current] = helper[helperRight]
                    helperRight++
                }
            }
            current++
        }

        val remaining = middle - helperLeft
        for (i in 0..remaining) {
            array[current + i] = helper[helperLeft + i]
        }
    }

    fun runTest() {
        for (case in Sorting.testCases) {
            mergeSort(case)
            Sorting.print(case)
        }
    }
}