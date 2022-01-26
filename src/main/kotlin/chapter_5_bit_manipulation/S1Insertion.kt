package chapter_5_bit_manipulation

import chapter_5_bit_manipulation.BitUtil.getBit
import chapter_5_bit_manipulation.BitUtil.toBinaryString
import chapter_5_bit_manipulation.BitUtil.updateBit

class S1Insertion {
    private fun insert(n: Int, m: Int, firstI: Int, j: Int): Int {
        var i = firstI
        var k = 0
        var num = n
        while (i <= j) {
            val bit = m.getBit(k)
            num = updateBit(num, i, bit == 1)
            i++
            k++
        }
        return num
    }

    fun runTest() {
        val nAsBinary = "10000000000"
        val mAsBinary = "10011"
        val n = nAsBinary.toInt(2)
        val m = mAsBinary.toInt(2)
        println("n: $nAsBinary")
        println("m: $mAsBinary")
        println("result: ${insert(n, m, 2, 6).toBinaryString(nAsBinary.length)}")
    }
}