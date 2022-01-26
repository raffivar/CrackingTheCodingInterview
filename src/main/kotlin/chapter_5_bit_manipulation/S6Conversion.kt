package chapter_5_bit_manipulation

import chapter_5_bit_manipulation.BitUtil.toBinaryString

class S6Conversion {
    private fun flip(num1: Int, num2: Int): Int {
        println("num1: $num1 (${num1.toBinaryString(10)})")
        println("num2: $num2 (${num2.toBinaryString(10)})")
        return num1.xor(num2).countOneBits()
    }

    fun runTest() {
        val functions = arrayListOf(this::flip)
        val testCases = arrayListOf(
            Pair(29, 15),
            Pair(7, 0)
        )
        for (function in functions) {
            for (case in testCases) {
                println("${function.name}(${case.first}, ${case.second}): ${function(case.first, case.second)}")
                println("------------------------------------------")
            }
        }
    }
}