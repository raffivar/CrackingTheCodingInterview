package chapter_10_sorting_and_searching.searching

class Searching {
    companion object {
        fun search() {
            val testCases = arrayListOf(
                Pair(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3),
                Pair(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 6),
                Pair(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 15)
            )
            val functions = arrayListOf(this::binarySearch, this::binarySearchRecursive)
            for (function in functions) {
                println("${function.name}:")
                for (case in testCases) {
                    when (val index = function(case.first, case.second)) {
                        -1 -> println("index of ${case.second} in array is: $index [Not found]")
                        else -> println("index of ${case.second} in array is: $index")
                    }
                }
                println()
            }
        }

        /**
         * Runtime: O(log(n))
         * Memory: O(1)
         */
        fun binarySearch(array: IntArray, num: Int): Int {
            var low = 0
            var high = array.lastIndex
            var mid: Int

            while (low <= high) {
                mid = (low + high) / 2
                when {
                    array[mid] < num -> low = mid + 1
                    array[mid] > num -> high = mid - 1
                    else -> return mid
                }
            }

            return -1
        }

        /**
         * Runtime: O(log(n))
         * Memory: O(log(n))
         */
        fun binarySearchRecursive(array: IntArray, num: Int): Int {
            return binarySearchRecursive(array, num, 0, array.lastIndex)
        }

        private fun binarySearchRecursive(array: IntArray, num: Int, low: Int, high: Int): Int {
            if (low > high) {
                return -1
            }

            val mid = (low + high) / 2
            return when {
                array[mid] < num -> binarySearchRecursive(array, num, mid + 1, high)
                array[mid] > num -> binarySearchRecursive(array, num, low, mid - 1)
                else -> mid
            }
        }
    }
}