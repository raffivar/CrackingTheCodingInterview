package chapter_5_bit_manipulation

import Solution
import chapter_5_bit_manipulation.BitUtil.getBit
import chapter_5_bit_manipulation.BitUtil.toBinaryString
import chapter_5_bit_manipulation.BitUtil.updateBit

class S1Insertion : Solution {
    private fun insert(n: Int, m: Int, firstI: Int, j: Int): Int {
        var i = firstI
        var k = 0
        var num = n
        while (i <= j) {
            val bitToInsert = m.getBit(k)
            num = updateBit(num, i, bitToInsert == 1)
            i++
            k++
        }
        return num
    }

    private fun insert2(n: Int, m: Int, i: Int, j: Int): Int {
        val allOnes = 0.inv()
        val left = allOnes.shl(j + 1)
        val right = 1.shl(i) - 1
        val mask = left or right
        val nCleared = n and mask
        val mShifted = m.shl(i)
        return nCleared or mShifted
    }

    override fun runTest() {
        val nAsBinary = "10000000000"
        val mAsBinary = "10011"
        val n = nAsBinary.toInt(2)
        val m = mAsBinary.toInt(2)
        val functions = arrayListOf(this::insert, this::insert2)
        for (function in functions) {
            println("---------------------------------------------")
            println("${function.name}:")
            println("n: $nAsBinary")
            println("m: $mAsBinary")
            println("result: ${function(n, m, 2, 6).toBinaryString(nAsBinary.length)}")
        }
    }
}