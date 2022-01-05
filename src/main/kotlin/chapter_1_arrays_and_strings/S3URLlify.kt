package chapter_1_arrays_and_strings

import java.lang.StringBuilder

class S3URLlify {
    private fun urlify(str: String): String {
        val sb = StringBuilder()
        for (char in str) {
            if (char == ' ') {
                sb.append("%20")
            } else {
                sb.append(char)
            }
        }
        return sb.toString()
    }

    fun runTest() {
        val functions = arrayListOf(this::urlify)
        val testCases = arrayListOf("This is my string")
        for (function in functions) {
            println("------------------------------------------")
            for (testCase in testCases) {
                println("${function.name}(\"$testCase\"): ${function(testCase)}")
            }
        }
    }
}