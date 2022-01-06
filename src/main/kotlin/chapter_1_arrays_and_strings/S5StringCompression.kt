package chapter_1_arrays_and_strings

import java.lang.StringBuilder

class S5StringCompression {
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

    fun runTest() {
        val functions = arrayListOf(this::compressString)
        val testCases = arrayListOf("aabbcccccaaa", "aabbccccca", "abcdcba")
        for (function in functions) {
            println("------------------------------------------")
            for (testCase in testCases) {
                println("${function.name}(\"$testCase\"): ${function(testCase)}")
            }
        }
    }
}