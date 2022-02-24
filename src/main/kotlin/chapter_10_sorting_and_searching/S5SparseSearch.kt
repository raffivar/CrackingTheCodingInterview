package chapter_10_sorting_and_searching

import Solution
import Util.Companion.asString

class S5SparseSearch : Solution {
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
            var i = (low + high) / 2
            while (i < high && array[i] == "") {
                i++
            }
            when {
                array[i] == "" -> high = i - 1
                array[i] > word -> high = i - 1
                array[i] < word -> low = i + 1
                else -> return i
            }
        }
        return -1
    }

    override fun runTest() {
        val example = arrayListOf("at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "")
        val functions = arrayListOf(this::regularSearch, this::binarySearch)
        val testCases = arrayListOf(
            Pair("ball", example),
            Pair("at", example),
            Pair("sex", example),
            Pair("dad", arrayListOf("", "", "", "", "", "", "", "", "", "", "dad", "", "")),
            Pair("word", arrayListOf("", "", "", "", "", "", "", "", "", "", "", "", "")),
            Pair("woof", arrayListOf("woof")),
            Pair("test", arrayListOf())
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