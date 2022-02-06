package chapter_10_sorting_and_searching.sorting

class SelectionSort {
    /**
     * Runtime [average + worst case]: O(n^2)
     * Memory: O(1)
     */

    private fun selectionSort(arr: IntArray) {
        val n = arr.size
        var temp: Int
        for (i in 0 until n) {
            var indexOfMin = i
            for (j in n - 1 downTo i) {
                if (arr[j] < arr[indexOfMin])
                    indexOfMin = j
            }
            if (i != indexOfMin) {
                temp = arr[i]
                arr[i] = arr[indexOfMin]
                arr[indexOfMin] = temp
            }
        }
    }

    fun sort(testCases: ArrayList<IntArray>) {
        for (case in testCases) {
            selectionSort(case)
            Sorting.print(case)
        }
    }
}