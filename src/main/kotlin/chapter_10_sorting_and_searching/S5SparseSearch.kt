package chapter_10_sorting_and_searching

import Util.Companion.asString

class S5SparseSearch {
    //Brute force
    private fun search(word: String, array: ArrayList<String>): Int {
        for (i in array.indices) {
            if (array[i] == word) {
                return i
            }
        }
        return -1
    }

    fun runTest() {
        val example = arrayListOf("at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "")
        val testCases = arrayListOf(Pair("ball", example))
        for (case in testCases) {
            println("Searching for [${case.first}] in ${case.second.asString()}")
            when (val result = search(case.first, case.second)) {
                -1 -> println("Not found")
                else -> println("Found in index [$result]")
            }
            println("-----------------------------------------------------------------------------------------")
        }
    }
}