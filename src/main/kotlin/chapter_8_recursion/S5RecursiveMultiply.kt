package chapter_8_recursion

class S5RecursiveMultiply {
    private fun multiply(num1: Int, num2: Int): Int {
        return multiplyByAddition(num1, num2, 0, 0)
    }

    private fun multiplyByAddition(num1: Int, num2: Int, result: Int, i: Int): Int {
        return when (i) {
            num2 -> 0
            else -> result + num1 + multiplyByAddition(num1, num2, result, i + 1)
        }
    }

    fun runTest() {
        val functions = arrayListOf(this::multiply)
        val testCases = arrayListOf(Pair(4, 5), Pair(3, 8))
        for (function in functions) {
            for (case in testCases) {
                println("${case.first} * ${case.second} = ${function(case.first, case.second)}")
            }
        }
    }
}