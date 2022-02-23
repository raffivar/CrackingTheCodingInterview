package chapter_6_math_and_logic

import Solution

class S2Basketball : Solution {
    private fun calculateProbability(percentage: Float) {
        val p = percentage / 100
        println("1/1: ${p * 100}% of success")
        println("2/3: ${calculateTwoOutOfThree(p) * 100}% of success")
        println("---------------------------------------")
    }

    private fun calculateTwoOutOfThree(s: Float): Float {
        val f = 1 - s //f = failure, s = success
        return twoOfThree(s, s, s) +
                twoOfThree(f, s, s) +
                twoOfThree(s, f, s) +
                twoOfThree(s, s, f)
    }

    private fun twoOfThree(p1: Float, p2: Float, p3: Float): Float {
        return p1 * p2 * p3
    }

    override fun runTest() {
        for (p in 100 downTo 0) {
            calculateProbability(p.toFloat())
        }
    }
}