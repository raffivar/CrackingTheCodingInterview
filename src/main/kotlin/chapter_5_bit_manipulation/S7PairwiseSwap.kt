package chapter_5_bit_manipulation

import Solution
import chapter_5_bit_manipulation.BitUtil.toBinaryString

class S7PairwiseSwap : Solution {
    private fun swap(num: Int): Int {
        return (num and (0xaaaaaaa)).shr(1) or (num and 0x55555555).shl(1)
    }

    override fun runTest() {
        val functions = arrayListOf(this::swap)
        val testCases = arrayListOf(953)
        for (function in functions) {
            for (case in testCases) {
                println("Before: [${case.toBinaryString(1)}] [$case]")
                val result = function(case)
                println("After: [${result.toBinaryString(1)}] [$result]")
            }
        }
    }
}