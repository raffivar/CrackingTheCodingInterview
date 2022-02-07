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
        while (low != high) {
            low = (low + high) / 2
            high = low + 1
            while (low >= 0 && array[low] == "") {
                low--
            }
            while (high < array.size && array[high] == "") {
                high++
            }
            when {
                low < 0 && high > array.lastIndex -> return -1 //no words in array
                low < 0 || word > array[high] -> { //no words in left, or word right of high
                    low = high
                    high = (low + high) / 2
                }
                high > array.lastIndex || word < array[low] -> { //no words in right, or word left of low
                    high = low
                    low /= 2
                }
                word == array[low] -> return low
                word == array[high] -> return high
            }
        }
        return when (low in 0..array.lastIndex && array[low] == word) { //final check
            true -> low
            false -> -1
        }
    }

    fun runTest() {
        val example = arrayListOf("at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "")
        val functions = arrayListOf(this::regularSearch, this::binarySearch)
        val testCases = arrayListOf(
            Pair("ball", example),
            Pair("at", example),
            Pair("sex", example),
            Pair("dad", arrayListOf("", "", "", "", "", "", "", "", "", "", "dad", "", "")),
            Pair("word", arrayListOf("", "", "", "", "", "", "", "", "", "", "", "", "")),
            Pair("woof", arrayListOf("woof"))
        )
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