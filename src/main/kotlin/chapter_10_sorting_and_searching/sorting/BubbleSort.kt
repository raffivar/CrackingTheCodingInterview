package chapter_10_sorting_and_searching.sorting

class BubbleSort {
    /**
     * Runtime [average + worst case]: O(n^2)
     * Memory: O(1)
     */

    private fun bubbleSort(arr: IntArray) {
        var swap = true
        while (swap) {
            swap = false
            for (i in 0 until arr.size - 1) {
                if (arr[i] > arr[i + 1]) {
                    val temp = arr[i]
                    arr[i] = arr[i + 1]
                    arr[i + 1] = temp
                    swap = true
                }
            }
        }
    }

    fun sort(testCases: ArrayList<IntArray>) {
        for (case in testCases) {
            bubbleSort(case)
            Sorting.print(case)
        }
    }
}