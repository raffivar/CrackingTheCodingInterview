package chapter_5_recursion

import java.awt.Point
import kotlin.math.min

class S12EightQueens {
    private val queens = mutableSetOf<Point>()
    private var numOfWays = 0

    private fun placeQueens(size: Int) {
        if (size == 0) {
            println("illegal size")
            return
        }
        val board = Array(size) { IntArray(size) { 0 } }
        placeNextQueen(0, board)
    }

    private fun placeNextQueen(x: Int, board: Array<IntArray>) {
        for (y in 0..board.lastIndex) {
            val queen = Point(x, y)
            if (isLegalQueen(queen, board)) {
                addQueen(queen, board)
                when (isBoardFull(board)) {
                    true -> {
                        printBoard(board)
                        numOfWays++
                    }
                    false -> placeNextQueen(x + 1, board)
                }
                removeQueen(queen, board)
            }
        }
    }

    private fun addQueen(queen: Point, board: Array<IntArray>) {
        queens.add(queen)
        board[queen.x][queen.y] = 1
    }

    private fun removeQueen(queen: Point, board: Array<IntArray>) {
        queens.remove(queen)
        board[queen.x][queen.y] = 0
    }

    private fun isBoardFull(board: Array<IntArray>): Boolean {
        //assuming board is not empty (already checked under "placeQueens()")
        return queens.size == board.size && isLegalBoard(board)
    }

    private fun isLegalBoard(board: Array<IntArray>): Boolean {
        for (queen in queens) {
            if (!isLegalQueen(queen, board)) {
                return false
            }
        }
        return true
    }

    private fun isLegalQueen(queen: Point, board: Array<IntArray>): Boolean {
        var p: Point

        //check vertical
        for (i in 0..board.lastIndex) {
            p = Point(i, queen.y)
            if (isOtherQueen(p, queen, board)) {
                return false
            }
        }

        //Check horizontal
        for (y in 0..board[0].lastIndex) {
            p = Point(queen.x, y)
            if (isOtherQueen(p, queen, board)) {
                return false
            }
        }

        //Check diagonal #1
        var offset = min(queen.x, queen.y)
        var x = queen.x - offset
        var y = queen.y - offset
        while (x < board.size && y < board.size) {
            p = Point(x, y)
            if (isOtherQueen(p, queen, board)) {
                return false
            }
            x++
            y++
        }

        //Check diagonal #2
        offset = min(queen.x, board.size - 1 - queen.y)
        y = queen.y + offset
        x = queen.x - offset
        while (x < board.size && y >= 0) {
            p = Point(x, y)
            if (isOtherQueen(p, queen, board)) {
                return false
            }
            x++
            y--
        }

        return true
    }

    private fun isOtherQueen(p: Point, queen: Point, board: Array<IntArray>): Boolean {
        return isQueen(p, board) && !isCurrentQueen(p, queen)
    }

    private fun isQueen(p: Point, board: Array<IntArray>): Boolean {
        return board[p.x][p.y] == 1
    }

    private fun isCurrentQueen(p: Point, queen: Point): Boolean {
        return p.x == queen.x && p.y == queen.y
    }

    private fun printBoard(board: Array<IntArray>) {
        for (r in board) {
            for (c in r) {
                print("$c ")
            }
            println()
        }
        println("---------------------------------")
    }

    fun runTest() {
        val functions = arrayListOf(this::placeQueens)
        val testCases = arrayListOf(4, 5, 6, 7, 8)
        for (function in functions) {
            for (testCase in testCases) {
                numOfWays = 0
                function(testCase)
                println("Num of ways found for size [$testCase]: $numOfWays\n")
            }
        }
    }
}