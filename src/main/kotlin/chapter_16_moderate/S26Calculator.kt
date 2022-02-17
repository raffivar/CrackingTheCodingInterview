package chapter_16_moderate

class S26Calculator {
    private fun calc(expression: String): Int {
        return 0
    }

    fun runTest() {
        val testCases = arrayListOf("2*3+5/6*3+15")
        for (case in testCases) {
            print("$case = ${calc(case)}")
        }
    }
}