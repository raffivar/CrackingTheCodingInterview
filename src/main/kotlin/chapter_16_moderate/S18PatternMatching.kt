package chapter_16_moderate

import java.lang.StringBuilder

class S18PatternMatching {
    private fun isPattern(pattern: String, str: String): Boolean {
        val substrings = getAllSubstrings(str)
        for (i in 0..substrings.lastIndex) {
            for (j in i + 1..substrings.lastIndex) {
                val sub1 = substrings[i]
                val sub2 = substrings[j]
                if (patternToText(pattern, sub1, sub2) == str || patternToText(pattern, sub2, sub1) == str) {
                    return true
                }
            }
        }
        return false
    }

    private fun getAllSubstrings(str: String): ArrayList<String> {
        val result = ArrayList<String>()
        //Copy the chars themselves (each one counts as a substring by its own)
        for (c in str) {
            result.add(c.toString())
        }
        //The rest of the calculations (more than 1 char per substring)
        var start = 0
        for (i in 1..str.lastIndex) {
            for (j in 0..str.lastIndex - i) {
                val sum = result[start + j] + str[i + j]
                result.add(sum)
            }
            start = result.size - str.length + i
        }
        return result
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
            println("pattern: ${case.first}\nvalue: ${case.second}")
            println(isPattern(case.first, case.second))
        }
    }
}