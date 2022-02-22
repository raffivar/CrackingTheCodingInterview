package chapter_1_arrays_and_strings

import Solution
import java.lang.StringBuilder

class S6StringCompression : Solution {
    private fun compressString(str: String): String {
        if (str.isBlank()) {
            return ""
        }

        val sb = StringBuilder()
        var i = 0
        while (i < str.length) {
            sb.append(str[i])
            var counter = 1
            var j = i + 1
            while (j < str.length && str[j] == str[i]) {
                counter++
                j++
            }
            sb.append(counter)
            i = j
        }

        return sb.toString()
    }

    override fun runTest() {
        val functions = arrayListOf(this::compressString)
        val testCases = arrayListOf("aabbcccccaaa", "aabbccccca", "abcdcba")
        for (function in functions) {
            for (case in testCases) {
                println("${function.name}(\"$case\"): ${function(case)}")
            }
        }
    }
}