package chapter_10_sorting_and_searching.sorting_algorithms

class Sorting {
    companion object {
        fun print(sorted: IntArray) {
            for (k in sorted) {
                print("$k ")
            }
            println("\n-------------------------------")
        }
    }

    val testCases = arrayListOf(
        intArrayOf(2, 15, 1, 8, 4),
        intArrayOf(2, 15, 1, 8, 52, 4)
    )

    fun sort() {
        BubbleSort().sort(testCases)
        SelectionSort().sort(testCases)
        MergeSort().sort(testCases)
        QuickSort().sort(testCases)
    }
}