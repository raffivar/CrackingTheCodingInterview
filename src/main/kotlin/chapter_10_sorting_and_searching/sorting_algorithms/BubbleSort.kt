package chapter_10_sorting_and_searching.sorting_algorithms

class BubbleSort {
    private fun sort(arr: IntArray): IntArray {
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

    fun runTest() {
        for (case in Sorting.testCases) {
            val sorted = sort(case)
            Sorting.print(sorted)
        }
    }
}