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

    private fun rotateMatrixLoop(matrix: Array<IntArray>) {
        var start = 0
        var end = matrix.lastIndex

        while (start <= end) {
            for (i in start until end) {
                val temp = matrix[start][i]
                matrix[start][i] = matrix[start + end - i][start]
                matrix[start + end - i][start] = matrix[end][start + end - i]
                matrix[end][start + end - i] = matrix[i][end]
                matrix[i][end] = temp
            }
            start++
            end--
        }
    }

    private fun rotateMatrixRec(matrix: Array<IntArray>) {
        rotateMatrixRec(matrix, 0, matrix.lastIndex)
    }

    private fun rotateMatrixRec(matrix: Array<IntArray>, start: Int, end: Int) {
        if (end - start <= 0) {
            return
        }

        for (i in start until end) {
            val temp = matrix[start][i]
            matrix[start][i] = matrix[start + end - i][start]
            matrix[start + end - i][start] = matrix[end][start + end - i]
            matrix[end][start + end - i] = matrix[i][end]
            matrix[i][end] = temp
        }

        rotateMatrixRec(matrix, start + 1, end - 1)
    }

    fun runTest() {
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

        for (case in testCases) {
            println("BEFORE:\n${Util.matrixAsString(case)}")
            println("AFTER [Copying into another matrix]:\n${Util.matrixAsString(rotateMatrix(case))}")
            rotateMatrixLoop(case)
            println("AFTER [Modifying original matrix using loop]:\n${Util.matrixAsString(case)}")
            rotateMatrixRec(case)
            println("AFTER [Modifying original matrix AGAIN using recursion]:\n${Util.matrixAsString(case)}")
            println("----------------------------------------------------------") }
    }
}