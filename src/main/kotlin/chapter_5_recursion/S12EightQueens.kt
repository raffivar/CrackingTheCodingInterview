package chapter_5_recursion

import java.awt.Point

class S12EightQueens {
    private val board = Array(8) { IntArray(8) { 0 } }

    private fun placeQueens() {

    }

    private fun addQueen(q: Point) {
        board[q.x][q.y] = 1
    }

    private fun removeQueen(q: Point) {
        board[q.x][q.y] = 0
    }

    private fun isLegalQueen(q: Point): Boolean {
        var p = Point(0, 0)

        //check vertical
        for (i in 0..board.lastIndex) {
            p = Point(i, p.y)
            if (isOtherQueen(p, q, board)) {
                return false
            }
        }

        //Check horizontal
        for (i in 0..board[0].lastIndex) {
            p = Point(p.x, i)
            if (isOtherQueen(p, q, board)) {
                return false
            }
        }

        //Check diagonal #1
        var i = 0
        var j = 0
        while (i < board.size && j < board.size) {
            p = Point(i, j)
            if (isOtherQueen(p, q, board)) {
                return false
            }
            i++
            j++
        }

        //Check diagonal #2
        i = 0
        j = board.lastIndex
        while (i < board.size && j > 0) {
            p = Point(i, j)
            if (isOtherQueen(p, q, board)) {
                return false
            }
            i++
            j--
        }
        return true
    }

    private fun isOtherQueen(p: Point, q: Point, board: Array<IntArray>): Boolean {
        return isQueen(p, board) && !isCurrentQueen(p, q)
    }

    private fun isQueen(p: Point, board: Array<IntArray>): Boolean {
        return board[p.x][p.y] == 1
    }

    private fun isCurrentQueen(p: Point, q: Point): Boolean {
        return p.x == q.x && p.y == q.y
    }

    private fun printBoard(board: Array<IntArray>) {
        for (r in board) {
            for (c in r) {
                print("$c ")
            }
            println()
        }
        println("----------------------------------------------")
    }

    fun runTest() {
        placeQueens()
    }
}