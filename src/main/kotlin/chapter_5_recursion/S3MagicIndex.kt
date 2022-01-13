package chapter_5_recursion

import java.lang.StringBuilder

class S3MagicIndex {
    private fun magicIndexDistinct(a: Array<Int>): Boolean {
        return magicIndex1(a, 0, a.lastIndex)
    }

    private fun magicIndex1(a: Array<Int>, start: Int, end: Int): Boolean {
        if (end - start <= 1) {
            return false
        }
        val i = start + (end - start) / 2
        printLog(a, i, start, end)
        return when {
            a[i] > i -> magicIndex1(a, start, i)
            a[i] < i -> magicIndex1(a, i, end)
            a[i] == i -> true
            else -> false
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
        return when {
            i < start || i > end -> false
            a[i] == i -> true
            else -> sideHasMagicIndex(a, a[i], start, end)
        }
    }

    private fun printLog(a: Array<Int>, i: Int, start: Int, end: Int) {
        val result = when {
            i < start || i > end -> "out of bounds"
            else -> "a[$i] = ${a[i]}"
        }
        println("[$start, $end] -> a[$i] = $result")
    }

    fun runTest() {
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
                println(arrayAsString(case))
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
                println(arrayAsString(case))
                when (function(case)) {
                    true -> println("found magic index\n")
                    false -> println("no magic index\n")
                }
            }
        }
    }

    private fun arrayAsString(array: Array<Int>): String {
        val sb = StringBuilder()
        for (num in array) {
            sb.append("$num, ")
        }
        return "[${sb.removeSuffix(", ")}]"
    }
}