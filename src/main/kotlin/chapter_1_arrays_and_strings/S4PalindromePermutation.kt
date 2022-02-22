package chapter_1_arrays_and_strings

import Solution

class S4PalindromePermutation : Solution {
    private fun isPalindromePermutation(str: String): Boolean {
        val instancesOfChars = HashMap<Char, Int>()

        for (char in str.lowercase()) {
            if (char != ' ') {
                instancesOfChars[char] = instancesOfChars[char] ?: 0
                instancesOfChars[char] = instancesOfChars[char]!! + 1
            }
        }

        var oddInstancesOfChar = 0
        for (instancesOfChar in instancesOfChars.values) {
            if (instancesOfChar % 2 != 0) {
                oddInstancesOfChar++
                if (oddInstancesOfChar > 1) {
                    return false
                }
            }
        }

        return true
    }

    override fun runTest() {
        val functions = arrayListOf(this::isPalindromePermutation)
        val testCases = arrayListOf("aaabaaa", "Tact Coa")
        for (function in functions) {
            for (case in testCases) {
                println("${function.name}(\"$case\"): ${function(case)}")
            }
        }
    }
}