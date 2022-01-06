package chapter_1_arrays_and_strings

class S4PalindromePermutation {
    private fun isPalindromePermutation(str: String): Boolean {
        val instancesOfChars = HashMap<Char, Int>()

        for (char in str.lowercase()) {
            if (char != ' ') {
                if (instancesOfChars.containsKey(char)) {
                    instancesOfChars[char] = instancesOfChars[char]!! + 1
                } else {
                    instancesOfChars[char] = 1
                }
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

    fun runTest() {
        val functions = arrayListOf(this::isPalindromePermutation)
        val testCases = arrayListOf("aaabaaa", "Tact Coa")
        for (function in functions) {
            println("------------------------------------------")
            for (testCase in testCases) {
                println("${function.name}(\"$testCase\"): ${function(testCase)}")
            }
        }
    }
}