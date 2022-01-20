package chapter_6_math_and_logic

import kotlin.math.max
import kotlin.math.min

class TheEggDropProblems {
    /**
     * For egg #1, we need to throw it from the floors:
     * X
     * 2X - 1
     * 3X - 2
     * 4X - 3
     * ....
     * The final result has to get to at least 99.
     * Then we run over what's left.
     * The first X that yields this result is 14.
     *
     */

    private val floors = 100

    private fun throwEggs(firstFloor: Int, initialDiff: Int) {
        println("First floor: $firstFloor")
        var diff = initialDiff

        println("Egg #1:")
        var i = 0
        var egg1 = 0
        while (egg1 + diff <= floors) {
            i++
            egg1 += when (egg1) {
                0 -> firstFloor
                else -> diff
            }
            println("Throwing egg #1 from floor #$egg1 [move #$i]")
            diff--
        }

        println("Egg #2:")
        var j = 0
        var egg2 = (egg1 - diff - 1)
        while (egg2 < egg1 - 1 && egg2 < floors) {
            j++
            egg2++
            println("Throwing egg #2 from floor #$egg2 [move #${i + j}]")
        }
        println("min moves (for $firstFloor): ${min(firstFloor, i + j)}")
        println("max moves (for $firstFloor): ${max(firstFloor, i + j)}")
        println("-----------------------------------------------------")
    }

    fun runTest() {
        throwEggs(14, 14)
        throwEggs(15, 14)
        throwEggs(16, 15)
    }
}