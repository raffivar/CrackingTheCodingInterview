package chapter_1_arrays_and_strings

class S2CheckPermutation {
    private fun checkPermutation(str1: String, str2: String): Boolean {
        val sorted1 = String(str1.toCharArray().apply { sort() })
        val sorted2 = String(str2.toCharArray().apply { sort() })
        return sorted1 == sorted2
    }

    fun runTest() {
        val functions = arrayListOf(this::checkPermutation)
        val testCases = arrayListOf(
            Pair("aaaa", "aaaa"),
            Pair("aaaa", "aabb"),
            Pair("aaBa", "aBaa")
        )
        for (function in functions) {
            println("------------------------------------------")
            for (testCase in testCases) {
                println("${function.name}(\"${testCase.first}\", \"${testCase.second}\"): ${function(testCase.first, testCase.second)}")
            }
        }
    }
}