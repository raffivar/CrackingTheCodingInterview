package chapter_7_oop_design

import java.awt.Point
import kotlin.math.abs
import kotlin.math.log10
import kotlin.math.pow

fun Int.length() = when (this) {
    0 -> 1
    else -> log10(abs(toDouble())).toInt() + 1
}

class S6Jigsaw {
    class Piece(var id: Int, x: Int, y: Int) : Point(x, y) {
        val connectedWith = hashSetOf<Piece>()

        fun isConnectedWith(other: Piece): Boolean {
            return this.connectedWith.contains(other)
        }

        fun fitsWith(other: Piece): Boolean {
            return abs(this.x - other.x) == 1 && this.y == other.y || //strictly vertical
                    this.x == other.x && abs(this.y - other.y) == 1 //strictly horizontal
        }

        fun connectWith(other: Piece) {
            this.connectedWith.add(other)
            other.connectedWith.add(this)
            println("Connected [${this.id}] with [${other.id}].")
        }
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
            printPieces()
            while (!isSolved()) {
                for (p1 in piecesById.values) {
                    for (p2 in piecesById.values) {
                        if (p1 != p2 && p1.fitsWith(p2)) {
                            attemptConnect(p1, p2)
                        }
                    }
                }
            }
            println("Puzzle solved.")
        }

        private fun printPieces() {
            println("Pieces:")
            for (piece in piecesById.values) {
                val maxId = n.toDouble().pow(2).toInt()
                val padLength = maxId.length() - piece.id.length() + 1
                print("[${piece.id.toString().padStart(padLength, '0')}] ")
                if (piece.y == n - 1) {
                    println()
                }
            }
            println()
        }

        private fun readPieceIdFromUser(): Int {
            var pieceId = readln().toIntOrNull()
            while (pieceId == null || !piecesById.containsKey(pieceId)) {
                println("Invalid choice, please try again")
                pieceId = readln().toIntOrNull()
            }
            return pieceId
        }

        private fun attemptConnect(p1: Piece, p2: Piece) {
            when {
                p1.isConnectedWith(p2) -> println("[${p1.id}] already connected with [${p2.id}].")
                !p1.fitsWith(p2) -> println("[${p1.id}] does not fit with [${p2.id}].")
                else -> p1.connectWith(p2)
            }
        }

        private fun isSolved(): Boolean {
            for (piece in piecesById.values) {
                if (!isPieceComplete(piece)) {
                    return false
                }
            }
            return true
        }

        private fun isPieceComplete(piece: Piece): Boolean {
            when {
                !isSidePiece(piece) && piece.connectedWith.size < 4 -> return false //center piece
                !isCornerPiece(piece) && piece.connectedWith.size < 3 -> return false //side but not corner
                piece.connectedWith.size < 2 -> return false //corner piece
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
        Jigsaw(5).start()
    }
}