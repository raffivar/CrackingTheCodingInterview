package chapter_16_moderate

import kotlin.math.abs

class S7NumberMax {
    /**
     * 1. "Step" on the midpoint:
     * (a+b)/2
     * 2. "Walk" half the distance between them
     * on the positive direction on real line, meaning:
     * add abs(a−b)/2
     * 3. Add 1+2 and you get this:
     */
    private fun getMax(a: Int, b: Int): Int {
        return (a + b + abs(a - b)) / 2
    }

    fun runTest() {
        val testCases = arrayListOf(
            Pair(5, 10),
            Pair(7, 3),
            Pair(4, -1),
            Pair(3, 1),
            Pair(13, 22),
            Pair(-6, -10),
            Pair(-5, 18)
        )
        for (case in testCases) {
            println("Max(${case.first}, ${case.second}) = ${getMax(case.first, case.second)}")
        }
    }
}