package chapter_16_moderate

import Solution

class S24PairsWithSum : Solution {
    private fun getSumPairs(array: IntArray, sum: Int): ArrayList<Pair<Int, Int>> {
        val result = ArrayList<Pair<Int, Int>>()
        for (i in 0..array.lastIndex) {
            for (j in i + 1..array.lastIndex) {
                if (array[i] + array[j] == sum) {
                    result.add(Pair(array[i], array[j]))
                }
            }
        }
        return result
    }

    override fun runTest() {
        val testCases = arrayListOf(
            Pair(intArrayOf(1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19), 17)
        )
        for (case in testCases) {
            println("sum: [${case.second}]")
            println("array: ${Util.arrayAsString(case.first)}")
            val result = getSumPairs(case.first, case.second)
            for (pair in result) {
                print("[${pair.first},${pair.second}] ")
            }
            println("\n-----------------------------------------------------")
        }
    }
}