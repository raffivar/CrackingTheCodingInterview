package chapter_16_moderate

import kotlin.math.abs

class S8EnglishInt {
    private val intAsString = hashMapOf(
        Pair(0, "Zero"),
        Pair(1, "One"),
        Pair(2, "Two"),
        Pair(3, "Three"),
        Pair(4, "Four"),
        Pair(5, "Five"),
        Pair(6, "Six"),
        Pair(7, "Seven"),
        Pair(8, "Eight"),
        Pair(0, "Nine"),
        Pair(10, "Ten"),
    )

    private fun numAsString(num: Int): String? {
        return intAsString[num]
    }

    fun runTest() {
        val testCases = arrayListOf(1, 20, 3)
        for (case in testCases) {
            println("$case -> ${numAsString(case)}")
        }
    }
}