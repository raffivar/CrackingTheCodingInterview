package chapter_10_sorting_and_searching.sorting

class Sorting {
    fun sort() {
        val functions = arrayListOf(this::bubbleSort, this::selectionSort, this::mergeSort, this::quickSort)
        for (function in functions) {
            val testCases = arrayListOf(//Need to re-create cases to have them not-ordered
                //intArrayOf(),
                intArrayOf(2, 15, 1, 8, 4),
                intArrayOf(2, 15, 1, 8, 52, 4)
            )
            println("${function.name}:")
            for (case in testCases) {
                print("Before: ")
                printArray(case)
                function(case)
                print("After: ")
                printArray(case)
            }
            println()
        }
    }

    private fun printArray(array: IntArray) {
        for (k in array) {
            print("$k ")
        }
        println()
    }

    /**
     * Helper method to all but mergeSort
     */
    private fun swap(array: IntArray, i: Int, j: Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }

    /**
     * Runtime [average + worst case]: O(n^2)
     * Memory: O(1)
     */
    private fun bubbleSort(array: IntArray) {
        var swap = true
        while (swap) {
            swap = false
            for (i in 0 until array.size - 1) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1)
                    swap = true
                }
            }
        }
    }

    /**
     * Runtime [average + worst case]: O(n^2)
     * Memory: O(1)
     */
    private fun selectionSort(array: IntArray) {
        val n = array.size
        for (i in 0 until n) {
            var indexOfMin = i
            for (j in n - 1 downTo i) {
                if (array[j] < array[indexOfMin]) {
                    indexOfMin = j
                }
            }
            if (i != indexOfMin) {
                swap(array, i, indexOfMin)
            }
        }
    }

    /**
     * Runtime [average + worst case]: O(n * log(n))
     * Memory: Depends
     */
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

    /**
     * Runtime [average]: O(n * log(n))
     * Runtime [worst case]: O(n^2)
     * Memory: O(log(n))
     */
    private fun quickSort(array: IntArray) {
        quickSort(array, 0, array.lastIndex)
    }

    private fun quickSort(array: IntArray, left: Int, right: Int) {
        val index = partition(array, left, right)
        if (left < index - 1) {
            quickSort(array, left, index - 1)
        }
        if (index < right) {
            quickSort(array, index, right)
        }
    }

    private fun partition(array: IntArray, _left: Int, _right: Int): Int {
        var left = _left
        var right = _right

        val pivot = array[(left + right) / 2]
        while (left <= right) {
            while (array[left] < pivot) {
                left++
            }
            while (array[right] > pivot) {
                right--
            }
            if (left <= right) {
                swap(array, left, right)
                left++
                right--
            }
        }
        return left
    }
}