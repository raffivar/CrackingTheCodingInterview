package chapter_10_sorting_and_searching.sorting

class Sorting {
    fun sort() {
        val functions = arrayListOf(this::bubbleSort, this::selectionSort, this::mergeSort)
        for (function in functions) {
            val testCases = arrayListOf(//Need to re-create cases to have them not-ordered
                intArrayOf(2, 15, 1, 8, 4),
                intArrayOf(2, 15, 1, 8, 52, 4)
            )
            for (case in testCases) {
                function(case)
                printArray(case)
            }
            println("-------------------------------")
        }
    }

    private fun printArray(array: IntArray) {
        for (k in array) {
            print("$k ")
        }
        println()
    }

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
}