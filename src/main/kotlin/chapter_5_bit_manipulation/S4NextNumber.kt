package chapter_5_bit_manipulation

import Solution
import chapter_5_bit_manipulation.BitUtil.toBinaryString
import chapter_5_bit_manipulation.BitUtil.updateBit
import kotlin.math.log2

class S4NextNumber : Solution {
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

    private fun getPrev(num: Int): Int {
        var n = num
        var c = num
        var c0 = 0
        var c1 = 0
        while (c and 1 == 1) {
            c1++
            c = c.shr(1)
        }
        if (c == 0) {
            return -1
        }
        while (c and 1 == 0 && c != 0) {
            c0++
            c = c.shr(1)
        }
        val p = c0 + c1
        n = n and 0.inv().shl(p + 1)
        val mask = (1.shl(c1 - 1) - 1)
        n = n or mask.shl(c0 - 1)
        return n
    }

    private fun getNext(num: Int): Int {
        var n = num
        var c = num
        var c0 = 0
        val c1 = 0
        while (c and 1 == 0 && c != 0) {
            c0++
            c = c.shr(1)
        }
        val p = c0 + c1
        if (p == 0 || p == 31) {
            return -1
        }
        n = n or 1.shl(p)
        n = n and (1.shl(p) - 1).inv()
        val mask = (1.shl(c1 - 1) - 1)
        n = n or mask
        return n
    }

    override fun runTest() {
        val functions = arrayListOf(this::nextSmallest, this::getPrev, this::nextBiggest, this::getNext)
        val testCases = arrayListOf(4, 7, 567)
        for (n in testCases) {
            println("--------------------------------------------------------------------------------")
            for (function in functions) {
                val nAsString = n.toBinaryString(10)
                val result = function(n)
                val resultAsString = result.toBinaryString(10)
                println("${function.name}: [$n -> $nAsString] -> [$result -> $resultAsString]")
            }
        }
    }
}