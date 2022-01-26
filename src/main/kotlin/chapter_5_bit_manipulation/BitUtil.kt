package chapter_5_bit_manipulation

object BitUtil {
    fun Int.toBinaryString(len: Int): String {
        return String.format("%" + len + "s", this.toString(2)).replace(" ".toRegex(), "0")
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
}