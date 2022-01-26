package chapter_5_bit_manipulation

import chapter_5_bit_manipulation.BitUtil.toBinaryString
import chapter_5_bit_manipulation.BitUtil.updateBit
import kotlin.math.log2

class S4NextNumber {
    private fun nextNumber(num: Int) {
        println("Number: $num (${num.toBinaryString(10)})")
        val nextSmallest = nextSmallest(num)
        println("Next smallest: $nextSmallest (${nextSmallest.toBinaryString(10)})")
        val nexBiggest = nextBiggest(num)
        println("Next biggest: $nexBiggest (${nexBiggest.toBinaryString(10)})")
        println("----------------------------------------------")
    }

    private fun nextSmallest(n: Int): Int {
        val ones = n.countOneBits()
        var num = 0
        for (i in 0 until ones) {
            num = updateBit(num, i, true)
        }
        return num
    }

    private fun nextBiggest(n: Int): Int {
        val ones = n.countOneBits()
        val bit = n.takeHighestOneBit()
        val bitIndex = log2(bit.toFloat()).toInt()
        var num = 0
        for (i in bitIndex downTo bitIndex - ones + 1) {
            num = updateBit(num, i, true)
        }
        if (num == n) {
            num = updateBit(num, bitIndex, false)
            num = updateBit(num, bitIndex + 1, true)
        }
        return num
    }

    fun runTest() {
        nextNumber(4)
        nextNumber(7)
        nextNumber(567)
    }
}