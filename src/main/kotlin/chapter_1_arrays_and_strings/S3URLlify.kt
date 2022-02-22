package chapter_1_arrays_and_strings

import Solution
import java.lang.StringBuilder

class S3URLlify : Solution {
    private fun urlify(str: String): String {
        val sb = StringBuilder()
        for (char in str) {
            when (char) {
                ' ' -> sb.append("%20")
                else -> sb.append(char)
            }
        }
        return sb.toString()
    }

    override fun runTest() {
        val functions = arrayListOf(this::urlify)
        val testCases = arrayListOf("This is my string")
        for (function in functions) {
            for (case in testCases) {
                println("${function.name}(\"$case\"): ${function(case)}")
            }
        }
    }
}