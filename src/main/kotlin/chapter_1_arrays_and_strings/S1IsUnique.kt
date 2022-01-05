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

    private fun isUnique2(str: String): Boolean {
        var i = 0
        while (i < str.length) {
            var j = i+1
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

    fun runTest() {
        val functions = arrayListOf(this::isUnique1, this::isUnique2)
        val testCases = arrayListOf("aaaa", "abcd", "aAbB")
        for (function in functions) {
            println("------------------------------------------")
            for (testCase in testCases) {
                println("${function.name}(\"$testCase\"): ${function(testCase)}")
            }
        }
    }
}