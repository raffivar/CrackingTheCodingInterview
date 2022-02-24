package chapter_8_recursion

import Solution

class S3MagicIndex : Solution {
    private fun magicIndexDistinct(array: Array<Int>): Boolean {
        return magicIndex1(array, 0, array.lastIndex)
    }

    private fun magicIndex1(array: Array<Int>, start: Int, end: Int): Boolean {
        if (end < start) {
            return false
        }
        val mid = (start + end) / 2
        printLog(array, mid, start, end)
        return when {
            array[mid] > mid -> magicIndex1(array, start, mid - 1)
            array[mid] < mid -> magicIndex1(array, mid + 1, end)
            array[mid] == mid -> true
            else -> false //Not possible
        }
    }

    private fun magicIndexIndistinct(a: Array<Int>): Boolean {
        return magicIndex2(a, 0, a.lastIndex)
    }

    private fun magicIndex2(a: Array<Int>, start: Int, end: Int): Boolean {
        if (end - start <= 1) {
            return false
        }
        val i = start + (end - start) / 2
        //test one side (either entire left or entire right)
        if (sideHasMagicIndex(a, i, start, end)) {
            return true
        }
        //test whatever is left in the middle
        printLog(a, i, start, end)
        return when {
            a[i] > i -> magicIndex2(a, start, i)
            a[i] < i -> magicIndex2(a, i, end)
            else -> false
        }
    }

    private fun sideHasMagicIndex(a: Array<Int>, i: Int, start: Int, end: Int): Boolean {
        printLog(a, i, start, end)
        return when (i) {
            !in start..end -> false
            a[i] -> true
            else -> sideHasMagicIndex(a, a[i], start, end)
        }
    }

    private fun printLog(a: Array<Int>, i: Int, start: Int, end: Int) {
        val result = when (i) {
            !in start..end -> "out of bounds"
            else -> "a[$i] = ${a[i]}"
        }
        println("[$start, $end] -> a[$i] = $result")
    }

    override fun runTest() {
        val functions1 = arrayListOf(this::magicIndexDistinct)
        val testCases1 = arrayListOf(
            arrayOf(-1, 0, 1, 2, 5, 6, 7, 8),
            arrayOf(-1, 0, 1, 3, 5, 6, 7, 8, 9),
            arrayOf(-1, 0, 1, 2, 4, 5, 6, 7, 9),
            arrayOf(-7, -5, -4, 1, 2, 3, 5, 7, 9),
            arrayOf(1, 2, 3, 4, 5, 6),
            arrayOf(-6, -5, -4, -3, -2, -1)

        )
        println("================================== DISTINCT ==================================")
        for (function in functions1) {
            for (case in testCases1) {
                println(Util.arrayAsString(case))
                when (function(case)) {
                    true -> println("found magic index\n")
                    false -> println("no magic index\n")
                }
            }
        }
        println("================================== INDISTINCT ==================================")
        val functions2 = arrayListOf(this::magicIndexIndistinct)
        val testCases2 = arrayListOf(
            arrayOf(-1, -1, -1, 0, 0, 0, 0, 0, 0, 10, 10, 10, 10, 11, 11, 11, 14),
            arrayOf(-5, -3, -1, 4, 5, 6, 6, 8, 9, 10, 44, 44, 44, 44, 44, 44, 44)
        )
        for (function in functions2) {
            for (case in testCases2) {
                println(Util.arrayAsString(case))
                when (function(case)) {
                    true -> println("found magic index\n")
                    false -> println("no magic index\n")
                }
            }
        }
    }
}