package chapter_5_bit_manipulation

import Solution

class S2BinaryToString : Solution {
    private fun printBinary(num: Double): String {
        var n = num
        if (n >= 1 || n <= 0) {
            return "ERROR (not between 0 and 1)"
        }
        val binary = StringBuilder()
        binary.append("0.")
        while (n > 0) {
            if (binary.length >= 32) {
                return "ERROR (exceeds 32 bit limit)"
            }
            val r = n * 2
            n = when {
                r >= 1 -> {
                    binary.append(1)
                    r - 1
                }
                else -> {
                    binary.append(0)
                    r
                }
            }
        }
        return binary.toString()
    }
    
    override fun runTest() {
        val functions = arrayListOf(this::printBinary)
        val testCases = arrayListOf(0.625, 0.75, 0.5, 0.25, 0.125, 0.1, 0.2, 0.72, 1.1)
        for (function in functions) {
            for (case in testCases) {
                println("$case -> ${function(case)}")
            }
        }
    }
}