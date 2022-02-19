package chapter_16_moderate

import java.lang.ArithmeticException
import kotlin.math.abs

class S9Operations {
    private fun negate(num: Int): Int {
        var result = 0
        val numToAdd = when {
            num < 0 -> 1
            else -> -1
        }
        for (i in 0 until abs(num)) {
            result += numToAdd
        }
        return result
    }

    private fun sameSign(a: Int, b: Int): Boolean {
        return (a >= 0 && b >= 0) || (a < 0 && b < 0)
    }

    private fun subtract(a: Int, b: Int): Int {
        return a + negate(b)
    }

    private fun multiply(a: Int, b: Int): Int {
        var sum = 0
        for (i in 1..abs(b)) {
            sum += abs(a)
        }
        return when {
            sameSign(a, b) -> sum
            else -> negate(sum)
        }
    }

    private fun divide(a: Int, b: Int): Int {
        if (b == 0) {
            throw ArithmeticException("Cannot divide be zero!")
        }
        var num = abs(a)
        var sum = 0
        while (num + negate(abs(b)) >= 0) {
            num += negate(abs(b))
            sum++
        }
        return when {
            sameSign(a, b) -> sum
            else -> negate(sum)
        }
    }

    fun runTest() {
        val testCases = arrayListOf(
            Pair(5, 10),
            Pair(7, 3),
            Pair(4, -1),
            Pair(3, 1),
            Pair(13, 22),
            Pair(-6, -10),
            Pair(-10, -2),
            Pair(18, -5),
            Pair(18, 0)
        )
        for (case in testCases) {
            println("${case.first} - ${case.second} = ${subtract(case.first, case.second)}")
            println("${case.first} * ${case.second} = ${multiply(case.first, case.second)}")
            println("${case.first} / ${case.second} = ${divide(case.first, case.second)}")
            println("------------------------")
        }
    }
}