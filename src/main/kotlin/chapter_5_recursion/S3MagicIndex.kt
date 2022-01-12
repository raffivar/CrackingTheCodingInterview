package chapter_5_recursion

import java.lang.StringBuilder

class S3MagicIndex {
    private fun magicIndexDistinct(a: Array<Int>): Boolean {
        return magicIndex(a, 0, a.lastIndex)
    }

    private fun magicIndex(a: Array<Int>, start: Int, end: Int): Boolean {
        if (end - start <= 1) {
            return false
        }
        val i = start + (end - start) / 2
        println("[$start, $end] -> a[$i] = ${a[i]}")
        return when {
            a[i] > i -> magicIndex(a, start, i)
            a[i] < i -> magicIndex(a, i, end)
            a[i] == i -> true
            else -> false
        }
    }

    fun runTest() {
        val functions = arrayListOf(this::magicIndexDistinct)
        val testCases = arrayListOf(
            arrayOf(-1, 0, 1, 2, 5, 6, 7, 8),
            arrayOf(-1, 0, 1, 3, 5, 6, 7, 8, 9),
            arrayOf(-1, 0, 1, 2, 4, 5, 6, 7, 9),
            arrayOf(-7, -5, -4, 1, 2, 3, 5, 7, 9),
            arrayOf(1, 2, 3, 4, 5, 6),
            arrayOf(-6, -5, -4, -3, -2, -1)

        )
        for (function in functions) {
            for (case in testCases) {
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