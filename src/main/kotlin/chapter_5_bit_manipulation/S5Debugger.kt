package chapter_5_bit_manipulation

import chapter_5_bit_manipulation.BitUtil.toBinaryString
import chapter_5_bit_manipulation.BitUtil.updateBit
import kotlin.math.log2

class S5Debugger {
    /**
     * ANSWER: This method checks whether or not n is a power of 2
     */
    private fun secret(num: Int): Boolean {
        val num2 = num - 1
        val result = num and (num - 1)
        println("num1: $num (${num.toBinaryString(10)})")
        println("num2: $num2 (${num2.toBinaryString(10)})")
        println("result: $result (${result.toBinaryString(10)})")
        return (num and (num - 1)) == 0
    }

    fun runTest() {
        val functions = arrayListOf(this::secret)
        val testCases = arrayListOf(4, 6, 8, 10, 11, 16)
        for (function in functions) {
            for (testCase in testCases) {
                println("${function.name}($testCase): ${function(testCase)}")
                println("------------------------------------------")
            }
        }
    }
}