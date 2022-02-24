package chapter_16_moderate

import Solution

class S21SumSwap : Solution {
    /**
     * sum1 - x + y = sum2 - y + x
     * sum1 - sum2 = 2x -2y
     * sum1 - sum2 = 2(x-y)
     * let diff be (sum1 - sum2):
     * diff = 2(x-y)
     */
    private fun sumSwap(a1: IntArray, a2: IntArray): Pair<Int, Int>? {
        val diff = Util.sumArray(a1) - Util.sumArray(a2)
        for (num1 in a1) {
            for (num2 in a2) {
                if (diff == 2 * (num1 - num2)) {
                    return Pair(num1, num2)
                }
            }
        }
        return null
    }

    override fun runTest() {
        val testCases = arrayListOf(
            Pair(
                intArrayOf(4, 1, 2, 1, 1, 2),
                intArrayOf(3, 6, 3, 3)
            ),
            Pair(
                intArrayOf(6, 8),
                intArrayOf(3, 6, 3, 3)
            )
        )
        for (case in testCases) {
            println("a1: ${Util.arrayAsString(case.first)}\na2: ${Util.arrayAsString(case.second)}")
            print("result: ")
            when (val result = sumSwap(case.first, case.second)) {
                null -> println("no matches found")
                else -> println("[${result.first}, ${result.second}]")
            }
            println("--------------------------------------------")
        }
    }
}