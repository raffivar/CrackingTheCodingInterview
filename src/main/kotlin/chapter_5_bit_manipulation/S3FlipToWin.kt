package chapter_5_bit_manipulation

import chapter_5_bit_manipulation.BitUtil.countBits
import chapter_5_bit_manipulation.BitUtil.getBit
import chapter_5_bit_manipulation.BitUtil.toBinaryString

class S3FlipToWin {
    private fun flipToWin(num: Int): Int {
        if (num == 0) { //all 0s
            return 1
        }

        val size = countBits(num)
        if (num and num + 1 == 0) { //all 1s
            return size
        }

        var maxSequence = 0
        var i = size - 1

        while (i >= 0) {
            var previousSequence = 0
            var currentSequence = 0

            while (i >= 0) { //Inspect current sequence of 1's (with holes of max one 0)
                when (num.getBit(i)) {
                    1 -> {
                        currentSequence++
                        if (i == 0) {
                            val result = currentSequence + previousSequence + 1
                            if (result > maxSequence) {
                                maxSequence = result
                            }
                        }
                    }
                    0 -> {
                        val result = previousSequence + currentSequence + 1
                        if (result > maxSequence) {
                            maxSequence = result
                        }
                        if (i == 0) {
                            return maxSequence
                        }
                        if (i > 0 && num.getBit(i - 1) == 1) {
                            previousSequence = currentSequence
                            currentSequence = 0
                        } else {
                            break
                        }
                    }
                }
                i--
            }

            while (i >= 0 && num.getBit(i) == 0 && i - 1 >= 0 && num.getBit(i) == 0) { //Find next sequence of 1's
                i--
            }
        }

        return maxSequence
    }

    fun runTest() {
        val functions = arrayListOf(this::flipToWin)
        val testCases = arrayListOf(1775, 7, 64543, 1032702, 8, 30)

        for (function in functions) {
            for (case in testCases) {
                println("[$case] -> [${case.toBinaryString(1)}]")
                println("Max potential sequence: ${function(case)}")
                println("-------------------------------------------------")
            }
        }
    }
}