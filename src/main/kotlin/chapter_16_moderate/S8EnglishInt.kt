package chapter_16_moderate

import Solution
import java.lang.StringBuilder
import java.util.*

class S8EnglishInt : Solution {
    private val negative = "Negative"
    private val smalls = arrayOf(
        "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    )
    private val tens = arrayOf("", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")
    private val hundred = "Hundred"
    private val bigs = arrayOf("", "Thousand", "Million", "Billion")

    private fun numAsString(number: Int): String {
        var num = number
        when {
            num == 0 -> return smalls[0]
            num < 0 -> return "$negative ${numAsString(-1 * num)}"
        }

        val parts = LinkedList<String>()

        var chunkCount = 0
        while (num > 0) {
            if (num % 1000 != 0) {
                val chunk = "${convertChunk(num % 1000)} ${bigs[chunkCount]}"
                parts.addFirst(chunk)
            }
            num /= 1000
            chunkCount++
        }

        return listToString(parts)
    }

    private fun convertChunk(number: Int): String {
        var num = number
        val parts = LinkedList<String>()

        if (num >= 100) {
            parts.addLast(smalls[num / 100])
            parts.addLast(hundred)
            num %= 100
        }

        when (num) {
            in 10..19 -> parts.addLast(smalls[num])
            in 20..99 -> {
                parts.addLast(tens[num / 10])
                num %= 10
            }
        }

        if (num in 1..9) {
            parts.addLast(smalls[num])
        }

        return listToString(parts)
    }

    private fun listToString(parts: LinkedList<String>): String {
        val sb = StringBuilder()
        while (parts.size > 1) {
            sb.append(parts.pop())
            sb.append(" ")
        }
        sb.append(parts.pop())
        return sb.toString()
    }

    override fun runTest() {
        val testCases = arrayListOf(1, -20, 3, 1245, 234, 999, 1000, -23432, 1328450, Int.MAX_VALUE, Int.MIN_VALUE + 1)
        for (case in testCases) {
            println("$case -> ${numAsString(case)}")
        }
    }
}