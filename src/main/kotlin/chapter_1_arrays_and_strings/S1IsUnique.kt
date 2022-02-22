package chapter_1_arrays_and_strings

import Solution

class S1IsUnique : Solution {
    private fun isUnique1(str: String): Boolean {
        val hasSet = hashSetOf<Char>()
        for (char in str) {
            if (hasSet.contains(char)) {
                return false
            }
            hasSet.add(char)
        }
        return true
    }

    private fun isUnique2(str: String): Boolean {
        var i = 0
        while (i < str.length) {
            var j = i + 1
            while (j < str.length) {
                if (str[i] == str[j]) {
                    return false
                }
                j++
            }
            i++
        }
        return true
    }

    private fun isUnique3(str: String): Boolean {
        val sorted = String(str.toCharArray().apply { sort() })
        var i = 0
        while (i < sorted.length - 1) {
            if (sorted[i] == sorted[i + 1]) {
                return false
            }
            i++
        }
        return true
    }

    override fun runTest() {
        val functions = arrayListOf(this::isUnique1, this::isUnique2, this::isUnique3)
        val testCases = arrayListOf("aaaa", "aBcA", "abcd", "aBAa")
        for (function in functions) {
            println("------------------------------------------")
            for (case in testCases) {
                println("${function.name}(\"$case\"): ${function(case)}")
            }
        }
    }
}