package chapter_10_sorting_and_searching

import Solution

class S10RankTheStream : Solution {
    private val tracker = HashMap<Int, Int>()

    private fun trace(x: Int) {
        when (val rank = tracker[x]) {
            null -> tracker[x] = 1
            else -> tracker[x] = rank + 1
        }
    }

    private fun getRankOfNumber(x: Int): Int {
        var count = 0
        for (i in 1..x) {
            val rank = tracker[i]
            rank?.let {
                count += it
            }
        }
        return count - 1
    }

    override fun runTest() {
        val testCases = arrayListOf(
            intArrayOf(5, 1, 4, 4, 5, 9, 7, 13, 3)
        )
        for (case in testCases) {
            Util.arrayAsString(case)
            for (num in case) {
                trace(num)
            }
            for (num in case) {
                println("Rank of current $num: ${getRankOfNumber(num)}")
            }
        }
    }
}