package chapter_10_sorting_and_searching

import Solution
import Util.Companion.asString
import java.lang.IndexOutOfBoundsException
import kotlin.math.pow

class S4SortedSearchNoSize : Solution {
    class Listy(src: IntArray) : ArrayList<Int>(src.toList()) {
        override val size: Int
            get() = -1

        override fun get(index: Int): Int {
            return try {
                super.get(index)
            } catch (e: IndexOutOfBoundsException) {
                -1
            }
        }
    }

    private fun search(listy: Listy, num: Int): Int {
        val edges = getLowHigh(listy, num)
        var low = edges.first
        var high = edges.second
        var mid: Int
        println("Low: [$low], high: [$high]")
        //Binary search
        while (low <= high) {
            mid = (low + high) / 2
            when {
                listy[mid] < num -> low = mid + 1
                listy[mid] > num || (listy[mid] == -1 /*Added condition*/) -> high = mid - 1
                else -> return mid
            }
        }
        return -1
    }

    private fun getLowHigh(listy: Listy, num: Int): Pair<Int, Int> {
        var low = 0
        var high = 0
        while (listy[high] < num && listy[high] != -1) {
            low = high
            high = 2f.pow(high).toInt()
        }
        return Pair(low, high)
    }

    override fun runTest() {
        val listy = Listy(intArrayOf(1, 3, 4, 5, 7, 10, 14, 15, 16, 19, 20, 25))
        val testCases = arrayListOf(
            Pair(listy, 5),
            Pair(listy, 20),
            Pair(Listy(intArrayOf(20)), 20),
            Pair(Listy(intArrayOf()), 20)
        )
        for (case in testCases) {
            println("Searching for [${case.second}] in ${listy.asString()}")
            when (val result = search(case.first, case.second)) {
                -1 -> println("Not found")
                else -> println("Found in index [$result]")
            }
            println("-----------------------------------------------------------------------------------------")
        }
    }
}