package chapter_5_bit_manipulation

import kotlin.experimental.and
import kotlin.experimental.or

class S8DrawLine {
    private fun drawLine(screen: Array<Byte>, width: Int, x1: Int, x2: Int, y: Int) {
        val startOffset = x1 % 8
        var firstFullByte = x1 / 8
        if (startOffset != 0) {
            firstFullByte++
        }
        val endOffset = x1 % 8
        var lastFullByte = x1 / 8
        if (endOffset != 7) {
            lastFullByte--
        }
        // set full bytes
        for (b in firstFullByte..lastFullByte) {
            screen[(width / 8) * y + b] = (0xFF).toByte()
            // create masks for start and end of line;
            val startMask = (0xFF).shl(startOffset).toByte()
            val endMask = (0xFF).shl(endOffset + 1).inv().toByte()
            // set start and end of line
            if (x1 / 8 == x2 / 8) {
                val mask = (startMask and endMask)
                screen[width / 8 * y + (x1 / 8)] = screen[width / 8 * y + (x1 / 8)] or mask
            } else {
                if (startOffset != 0) {
                    val byteNumber = (width / 8) * y + firstFullByte - 1
                    screen[byteNumber] = screen[byteNumber] or startMask
                }
                if (endOffset != 0) {
                    val byteNumber = (width / 8) * y + lastFullByte + 1
                    screen[byteNumber] = screen[byteNumber] or endMask
                }
            }
        }
    }

    private fun printArray(array: Array<Byte>) {
        for (byte in array) {
            print("$byte -> ")
        }
        println("||")
    }


    fun runTest() {
        val functions = arrayListOf(this::drawLine)
        val testCases = arrayListOf(
            arrayOf(1.toByte(), 2.toByte(), 3.toByte(), 4.toByte(), 5.toByte(), 6.toByte())
        )
        for (function in functions) {
            for (case in testCases) {
                println("Before:")
                printArray(case)
                function(case, 7, 1, 4, 2)
                println("After:")
                printArray(case)
            }
        }
    }
}