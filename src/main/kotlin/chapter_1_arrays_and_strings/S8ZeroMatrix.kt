package chapter_1_arrays_and_strings

import Solution

class S8ZeroMatrix : Solution {
    private fun zeroMatrix(matrix: Array<IntArray>) {
        val places = arrayListOf<Pair<Int, Int>>()

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == 0) {
                    places.add(Pair(i, j))
                }
            }
        }

        for (place in places) {
            for (j in matrix[place.first].indices) {
                matrix[place.first][j] = 0
            }

            for (i in matrix[place.second].indices) {
                matrix[i][place.second] = 0
            }
        }
    }


    override fun runTest() {
        val functions = arrayListOf(this::zeroMatrix)

        val testCases = arrayListOf(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 0, 6),
                intArrayOf(7, 8, 9)
            ),

            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 0, 7, 8),
                intArrayOf(9, 1, 2, 3),
                intArrayOf(4, 6, 7, 2),
            ),

            arrayOf(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(6, 0, 8, 9, 3),
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(6, 7, 8, 0, 5),
                intArrayOf(1, 2, 3, 4, 5)
            )
        )

        for (function in functions) {
            println("------------------------------------------")
            for (testCase in testCases) {
                println("BEFORE:\n${matrixAstString(testCase)}")
                zeroMatrix(testCase)
                println("AFTER:\n${matrixAstString(testCase)}")
            }
        }
    }

    private fun matrixAstString(matrix: Array<IntArray>): String {
        val sb = StringBuilder()
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                sb.append("${matrix[i][j]} ")
            }
            sb.append("\n")
        }
        return sb.toString()
    }

}