package chapter_1_arrays_and_strings

import kotlin.math.abs

class S5OneAway {
    private fun isOneAway(str1: String, str2: String): Boolean {
        if (abs(str1.length - str2.length) > 1) {
            return false
        }

        var i = 0
        var j = 0

        while (i < str1.length && j < str2.length && str1[i] == str2[j]) {
            i++
            j++
        }

        if (i == str1.length || j == str2.length) {
            return true
        }

        if (str1.length == str2.length) {
            return str1.substring(i + 1, str1.length) == str2.substring(j + 1, str2.length)
        }

        if (str1.length < str2.length) {
            return str1.substring(i, str1.length) == str2.substring(j + 1, str2.length)
        }

        // str1.length > str2.length (has to be)
        return str1.substring(i + 1, str1.length) == str2.substring(j, str2.length)

    }

    fun runTest() {
        val functions = arrayListOf(this::isOneAway)
        val testCases = arrayListOf(
            Pair("aaaa", "aaaa"),
            Pair("aabaaa", "aacaaa"),
            Pair("aaaccc", "aaabccc"),
            Pair("aaBa", "aBaa"),
            Pair("pale", "ple"),
            Pair("pales", "pale"),
            Pair("pale", "bale"),
            Pair("pale", "bake"),

            )
        for (function in functions) {
            println("------------------------------------------")
            for (testCase in testCases) {
                println(
                    "${function.name}(\"${testCase.first}\", \"${testCase.second}\"): ${
                        function(
                            testCase.first,
                            testCase.second
                        )
                    }"
                )
            }
        }
    }
}