package chapter_1_arrays_and_strings

import Solution

class S9StringRotation : Solution {
    private fun isStringRotation(str1: String, str2: String): Boolean {
        var j = 0
        while (j < str2.length) {
            val prefix2 = str2.substring(0, j)
            val suffix2 = str2.substring(j, str2.length)
            val prefix1 = str1.substring(0, suffix2.length)
            val suffix1 = str1.substring(suffix2.length, str1.length)

            if (suffix2 == prefix1 && prefix2 == suffix1) {
                return true
            }

            j++
        }
        return false
    }

    override fun runTest() {
        val functions = arrayListOf(this::isStringRotation)
        val testCases = arrayListOf(
            Pair("wawerwottle", "erwottlewaw"),
            Pair("waterbottle", "erbottlewat"),
            Pair("waterbottle", "erbotTlewat"),
        )
        for (function in functions) {
            for (case in testCases) {
                println("${function.name}(\"${case.first}\", \"${case.second}\"): ${function(case.first, case.second)}")
            }
        }
    }
}