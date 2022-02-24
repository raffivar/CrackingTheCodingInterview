package chapter_8_recursion

import Solution
import java.util.*
import kotlin.collections.ArrayList

class S1TripleStep : Solution {
    private fun tripleSteps(numOfStairs: Int, possibleSteps: ArrayList<Int>): Int {
        return steps(0, numOfStairs, possibleSteps)
    }

    private fun steps(current: Int, total: Int, steps: ArrayList<Int>): Int {
        if (current == total) {
            println("END")
            return 1
        }
        var options = 0
        for (step in steps) {
            val after = current + step
            if (after <= total) {
                print("$current+$step [$after/$total] -> ")
                options += steps(after, total, steps)
            }
        }
        return options
    }

    private fun countWays(n: Int, possibleSteps: ArrayList<Int>): Int {
        val memo = IntArray(n + 1)
        Arrays.fill(memo, -1)
        return countWays(n, possibleSteps, memo)
    }

    private fun countWays(n: Int, possibleSteps: ArrayList<Int>, memo: IntArray): Int {
        return when {
            n < 0 -> 0
            n == 0 -> 1
            memo[n] > -1 -> memo[n]
            else -> {
                memo[n] = countWays(n - possibleSteps[0], possibleSteps, memo) +
                        countWays(n - possibleSteps[1], possibleSteps, memo) +
                        countWays(n - possibleSteps[2], possibleSteps, memo)
                memo[n]
            }
        }
    }

    override fun runTest() {
        val functions = arrayListOf(this::tripleSteps, this::countWays)
        val testCases = arrayListOf(
            Pair(4, arrayListOf(1, 2, 3))
        )
        for (function in functions) {
            for (case in testCases) {
                println("------------------------------------------------------------------------------------")
                println("stairs: ${case.first}")
                println("step sizes: ${case.second}")
                println("options to go up the stairs: ${function(case.first, case.second)}")
            }
        }
    }
}