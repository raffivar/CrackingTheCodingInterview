package chapter_16_moderate

import java.lang.StringBuilder

class S18PatternMatching {
    private fun isPattern(pattern: String, s: String): Boolean {
        return false
    }

    private fun patternToText(pattern: String, a: String, b: String): String {
        val sb = StringBuilder()
        for (char in pattern) {
            when (char) {
                'a' -> sb.append(a)
                'b' -> sb.append(b)
            }
        }
        return sb.toString()
    }

    fun runTest() {
        val testCases = arrayListOf(Pair("aabab", "catcatgocatgo"))
        for (case in testCases) {
            println("pattern: ${case.first}\nvalue:${case.second}")
            println(isPattern(case.first, case.second))
        }
    }
}