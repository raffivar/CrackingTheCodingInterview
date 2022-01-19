package chapter_7_oop_design

import java.awt.Point
import kotlin.math.abs

class S6Jigsaw {
    class Piece(var id: Int, x: Int, y: Int) : Point(x, y) {
        val connectedWith = hashSetOf<Piece>()
    }

    class Jigsaw(private val n: Int) {
        private val piecesById = hashMapOf<Int, Piece>()

        init {
            var id = 0
            for (x in 0 until n) {
                for (y in 0 until n) {
                    id++
                    piecesById[id] = Piece(id, x, y)
                }
            }
        }

        fun start() {
            while (!isSolved()) {
                printPieces()
                println("Choose first piece to connect:")
                val p1 = readPieceId()
                println("Choose second piece to connect:")
                val p2 = readPieceId()
                attemptConnect(piecesById[p1]!!, piecesById[p2]!!)
                println("------------------------------------------------")
            }
            println("Puzzle solved!")
        }

        private fun printPieces() {
            println("Pieces:")
            for (piece in piecesById) {
                print("[${piece.key}] ")
            }
            println()
        }

        private fun readPieceId(): Int {
            var pieceId = readln().toIntOrNull()
            while (pieceId == null || !piecesById.containsKey(pieceId)) {
                println("Invalid choice, please try again")
                pieceId = readln().toIntOrNull()
            }
            return pieceId
        }

        private fun attemptConnect(p1: Piece, p2: Piece) {
            when (fitsWith(p1, p2)) {
                true -> {
                    p1.connectedWith.add(p2)
                    p2.connectedWith.add(p1)
                    println("Connected [${p1.id}] with [${p2.id}]!")
                }
                false -> println("Cannot connect [${p1.id}] with [${p2.id}]!")
            }
        }

        private fun fitsWith(p1: Piece, p2: Piece): Boolean {
            return abs(p1.x - p2.x) == 1 && abs(p1.y - p2.y) != 1 || //strictly vertical
                    abs(p1.x - p2.x) != 1 && abs(p1.y - p2.y) == 1 //strictly horizontal
        }

        private fun isSolved(): Boolean {
            for (piece in piecesById.values) {
                when {
                    !isSidePiece(piece) && piece.connectedWith.size < 4 -> return false //center piece
                    !isCornerPiece(piece) && piece.connectedWith.size < 3 -> return false //side but not corner
                    piece.connectedWith.size < 2 -> return false //corner piece
                }
            }
            return true
        }

        private fun isSidePiece(piece: Piece): Boolean {
            return piece.x == 0 || //top
                    piece.x == n - 1 || //bottom
                    piece.y == 0 || //left
                    piece.y == n - 1 //right
        }

        private fun isCornerPiece(piece: Piece): Boolean {
            return piece.x == 0 && piece.y == 0 || //top left
                    piece.x == 0 && piece.y == n - 1 || //top right
                    piece.x == n - 1 && piece.y == 0 || //bottom left
                    piece.x == n - 1 && piece.y == n - 1 //bottom right
        }
    }

    fun runTest() {
        Jigsaw(2).start()
    }
}