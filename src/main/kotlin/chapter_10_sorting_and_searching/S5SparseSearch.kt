package chapter_10_sorting_and_searching

import Util.Companion.asString

class S5SparseSearch {
    //Brute force
    private fun regularSearch(word: String, array: ArrayList<String>): Int {
        for (i in array.indices) {
            if (array[i] == word) {
                return i
            }
        }
        return -1
    }

    //Binary search with extra steps
    private fun binarySearch(word: String, array: ArrayList<String>): Int {
        var low = 0
        var high = array.lastIndex
        while (low <= high) {
            high = (low + high) / 2
            while (high < array.size && array[high] != word) {
                high++
            }
            when {
                high == array.size || word < array[high] -> high = (low + high) / 2
                word > array[high] -> low = high
                else -> return high
            }
        }
        return -1
    }

    fun runTest() {
        val example = arrayListOf("at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "")
        val functions = arrayListOf(this::regularSearch, this::binarySearch)
        val testCases = arrayListOf(Pair("ball", example))
        for (function in functions) {
            println("${function.name}:")
            for (case in testCases) {
                println("Searching for [${case.first}] in ${case.second.asString()}")
                when (val result = function(case.first, case.second)) {
                    -1 -> println("Not found")
                    else -> println("Found in index [$result]")
                }
            }
            println("-----------------------------------------------------------------------------------------")
        }

    }
}