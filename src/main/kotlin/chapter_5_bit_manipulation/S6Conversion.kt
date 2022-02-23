package chapter_5_bit_manipulation

import chapter_5_bit_manipulation.BitUtil.toBinaryString

class S6Conversion {
    private fun flip(num1: Int, num2: Int): Int {
        return num1.xor(num2).countOneBits()
    }

    private fun flip2(num1: Int, num2: Int): Int {
        var count = 0
        var num = num1 and num2
        while (num != 0) {
            count += num and 1
            num = num.shr(1)
        }
        return count
    }

    private fun flip3(num1: Int, num2: Int): Int {
        var count = 0
        var num = num1 and num2
        while (num != 0) {
            count++
            num = num and (num - 1)
        }
        return count
    }

    fun runTest() {
        val functions = arrayListOf(this::flip, this::flip2, this::flip3)
        val testCases = arrayListOf(
            Pair(29, 15),
            Pair(7, 0)
        )
        for (case in testCases) {
            println("------------------------------------------")
            for (function in functions) {
                val num1 = case.first
                val num2 = case.second
                println("num1: $num1 (${num1.toBinaryString(10)})")
                println("num2: $num2 (${num2.toBinaryString(10)})")
                println("${function.name}($num1, $num2): ${function(num1, num2)}")
            }
        }
    }
}