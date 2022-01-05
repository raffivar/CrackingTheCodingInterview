package chapter_1_arrays_and_strings

class S1IsUnique {
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

    fun runTest() {
        val testCases = arrayListOf("aaaa", "abcd", "aAbB")
        for (testCase in testCases) {
            println("isUnique1(\"$testCase\"): ${isUnique1(testCase)}")
        }
    }
}