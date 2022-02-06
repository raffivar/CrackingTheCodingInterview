package chapter_10_sorting_and_searching.sorting_algorithms

class SelectionSort {
    private fun sort(arr: IntArray) {
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

    fun runTest() {
        for (case in Sorting.testCases) {
            sort(case)
            Sorting.print(case)
        }
    }
}