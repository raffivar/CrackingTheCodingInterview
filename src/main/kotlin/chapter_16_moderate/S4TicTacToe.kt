package chapter_16_moderate

class S4TicTacToe {
    private fun gameOver(matrix: Array<IntArray>): Boolean {
        val n = matrix.lastIndex
        val horizontal = Array(n + 1) { true }
        val vertical = Array(n + 1) { true }
        val diagonal = Array(2) { true }

        for (i in 0..n) {
            for (j in 0..n) {
                when (val value = matrix[i][j]) {
                    0 -> {
                        vertical[j] = false
                        horizontal[i] = false
                        diagonal[0] = false
                        diagonal[1] = false
                    }
                    else -> {
                        if (vertical[j] && i < n && matrix[i + 1][j] != value) {
                            vertical[j] = false
                        }
                        if (horizontal[i] && j < n && matrix[i][j + 1] != value) {
                            horizontal[i] = false
                        }
                        if (diagonal[0] && i == j && i < n && j < n && matrix[i + 1][j + 1] != value) {
                            diagonal[0] = false
                        }
                        if (diagonal[1] && n - i == j && i < n && j > 0 && matrix[i + 1][j - 1] != value) {
                            diagonal[1] = false
                        }
                    }
                }
            }
        }
        return horizontal.contains(true) || vertical.contains(true) || diagonal.contains(true)
    }

    fun runTest() {
        val testCases = arrayListOf(
            arrayOf(
                intArrayOf(1, 0, 0),
                intArrayOf(1, 1, 1),
                intArrayOf(2, 1, 2)
            ),
            arrayOf(
                intArrayOf(3, 5, 5, 5, 5),
                intArrayOf(3, 1, 8, 5, 3),
                intArrayOf(3, 2, 5, 4, 5),
                intArrayOf(3, 5, 8, 1, 5),
                intArrayOf(5, 2, 3, 4, 1)
            ),
            arrayOf(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(6, 1, 8, 9, 3),
                intArrayOf(1, 2, 1, 4, 5),
                intArrayOf(6, 7, 8, 1, 5),
                intArrayOf(1, 2, 3, 4, 1)
            )
        )
        for (case in testCases) {
            println(Util.matrixAsString(case))
            println(gameOver(case))
            println()
        }
    }
}