package chapter_5_recursion

import java.awt.Point
import kotlin.math.min

class S12EightQueens {
    private val size = 8
    private val board = Array(size) { IntArray(size) { 0 } }
    private val queens = mutableSetOf<Point>()
    private var numOfWays = 0

    private fun placeQueens() {
        placeNextQueen(0)
    }

    private fun placeNextQueen(x: Int) {
        for (y in 0..board.lastIndex) {
            val queen = Point(x, y)
            if (isLegalQueen(queen)) {
                addQueen(queen)
                when (isBoardFull()) {
                    true -> {
                        printBoard()
                        numOfWays++
                    }
                    false -> placeNextQueen(x + 1)
                }
                removeQueen(queen)
            }
        }
    }

    private fun addQueen(queen: Point) {
        queens.add(queen)
        board[queen.x][queen.y] = 1
    }

    private fun removeQueen(queen: Point) {
        queens.remove(queen)
        board[queen.x][queen.y] = 0
    }

    private fun isBoardFull(): Boolean {
        return queens.size == size && isLegalBoard()
    }

    private fun isLegalBoard(): Boolean {
        for (queen in queens) {
            if (!isLegalQueen(queen)) {
                return false
            }
        }
        return true
    }

    private fun isLegalQueen(queen: Point): Boolean {
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
        while (x < size && y < size) {
            p = Point(x, y)
            if (isOtherQueen(p, queen, board)) {
                return false
            }
            x++
            y++
        }

        //Check diagonal #2
        offset = min(queen.x, size - 1 - queen.y)
        y = queen.y + offset
        x = queen.x - offset
        while (x < size && y >= 0) {
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

    private fun printBoard() {
        for (r in board) {
            for (c in r) {
                print("$c ")
            }
            println()
        }
        println("---------------------------------")
    }

    fun runTest() {
        placeQueens()
        println("Num of ways found: $numOfWays")
    }
}