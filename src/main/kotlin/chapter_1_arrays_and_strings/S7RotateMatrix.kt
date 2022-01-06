package chapter_1_arrays_and_strings

class S7RotateMatrix {
    private fun rotateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        val n = matrix.size
        val ret = Array(n) { IntArray(n) }

        for (i in 0 until n) {
            for (j in 0 until n) {
                ret[i][j] = matrix[n - j - 1][i]
            }
        }

        return ret
    }

    fun runTest() {
        val functions = arrayListOf(this::rotateMatrix)

        val testCases = arrayListOf(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9)
            ),

            arrayOf(
                intArrayOf(11, 12, 13, 14),
                intArrayOf(15, 16, 17, 18),
                intArrayOf(19, 20, 21, 22),
                intArrayOf(23, 24, 25, 26),
            ),

            arrayOf(
                intArrayOf(21, 22, 23, 24, 25),
                intArrayOf(26, 27, 28, 29, 30),
                intArrayOf(31, 32, 33, 34, 35),
                intArrayOf(36, 37, 38, 39, 40),
                intArrayOf(41, 42, 43, 44, 45)
            )
        )

        for (function in functions) {
            println("------------------------------------------")
            for (testCase in testCases) {
                println("BEFORE:\n${matrixAstString(testCase)}")
                println("AFTER:\n${matrixAstString(rotateMatrix(testCase))}")
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