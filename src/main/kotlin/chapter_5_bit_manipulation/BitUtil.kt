package chapter_5_bit_manipulation

import kotlin.math.ln

object BitUtil {
    fun Int.toBinaryString(len: Int): String {
        return String.format("%" + len + "s", this.toString(2)).replace(" ".toRegex(), "0")
    }

    fun countBits(number: Int): Int {
        // log function in base 2
        // take only integer part
        return (ln(number.toDouble()) / ln(2.0) + 1).toInt()
    }


    fun Int.getBit(i: Int): Int {
        return when (this and 1.shl(i) != 0) {
            true -> 1
            false -> 0
        }
    }

    fun setBit(n: Int, i: Int): Int {
        return n or 1.shl(i)
    }

    fun updateBit(num: Int, i: Int, bit: Boolean): Int {
        val bitValue = when (bit) {
            true -> 1
            false -> 0
        }
        val mask = (1.shl(i)).inv()
        return (num and mask) or bitValue.shl(i)
    }

    /**
     * This function is redundant
     * Already built in - Int.countOneBits
     * This is just to understand things better
     */
    private fun Int.countSetBits(): Int {
        var num = this
        var count = 0
        while (num != 0) {
            count += num and 1
            num = num.shr(1)
        }
        return count
    }
}