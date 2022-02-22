package chapter_1_arrays_and_strings

import Solution

class S2CheckPermutation : Solution {
    private fun checkPermutation(str1: String, str2: String): Boolean {
        val sorted1 = String(str1.toCharArray().apply { sort() })
        val sorted2 = String(str2.toCharArray().apply { sort() })
        return sorted1 == sorted2
    }

    override fun runTest() {
        val functions = arrayListOf(this::checkPermutation)
        val testCases = arrayListOf(
            Pair("aaaa", "aaaa"),
            Pair("aaaa", "aabb"),
            Pair("aaBa", "aBaa")
        )
        for (function in functions) {
            for (case in testCases) {
                println("${function.name}(\"${case.first}\", \"${case.second}\"): ${function(case.first, case.second)}")
            }
        }
    }
}