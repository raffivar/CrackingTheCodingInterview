package chapter_10_sorting_and_searching.sorting_algorithms

class BubbleSort {
    private fun bubbleSort(arr: IntArray): IntArray {
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
        return arr
    }

    fun sort(testCases: ArrayList<IntArray>) {
        for (case in testCases) {
            val sorted = bubbleSort(case)
            Sorting.print(sorted)
        }
    }
}