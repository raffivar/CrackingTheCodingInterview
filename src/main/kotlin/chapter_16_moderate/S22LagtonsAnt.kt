package chapter_16_moderate

import java.util.*

class S22LagtonsAnt {
    enum class Direction { Up, Right, Down, Left }
    enum class Rotation { Clockwise, Counterclockwise }
    enum class TileColor { White, Black }
    class Tile(var color: TileColor = TileColor.White)

    class Grid : ArrayList<ArrayList<Tile>>() {
        private var rowSize = 0
        private var columnSize = 0

        init {
            this.addRow(0)
            this.addColumn(0)
        }

        fun addRow(i: Int) {
            val row: ArrayList<Tile> = ArrayList()
            for (j in 0 until rowSize) {
                row.add(Tile())
            }
            this.add(i, row)
            columnSize++
        }

        fun addColumn(i: Int) {
            for (row in this) {
                row.add(i, Tile())
            }
            rowSize++
        }
    }

    class Ant(val grid: Grid) {
        var tile = grid[0][0]
        var direction = Direction.Right
        var i = 0
        var j = 0

        fun move() {
            when (this.direction) {
                Direction.Up -> i--
                Direction.Right -> j++
                Direction.Down -> i++
                Direction.Left -> j--
            }
            when {
                i < 0 -> {
                    i = 0
                    grid.addRow(i)
                }
                j < 0 -> {
                    j = 0
                    grid.addColumn(j)
                }
                i > grid.lastIndex -> grid.addRow(i)
                j > grid[i].lastIndex -> grid.addColumn(j)
            }
            tile = grid[i][j]
            println("Moved $direction")
        }

        fun flip() {
            when (this.tile.color) {
                TileColor.White -> {
                    tile.color = TileColor.Black
                    rotate(Rotation.Clockwise)
                    println("Landed on White -> flipped to Black")
                }
                TileColor.Black -> {
                    tile.color = TileColor.White
                    rotate(Rotation.Counterclockwise)
                    println("Landed on Black -> flipped to White")
                }
            }
            println("New direction: $direction")
        }

        private fun rotate(rotation: Rotation) {
            val pivot = when (rotation) {
                Rotation.Clockwise -> +1
                Rotation.Counterclockwise -> -1
            }
            var ordinal = this.direction.ordinal + pivot
            when {
                ordinal > Direction.values().lastIndex -> ordinal = 0
                ordinal < 0 -> ordinal = Direction.values().lastIndex
            }
            this.direction = Direction.values()[ordinal]
        }
    }

    private fun printKMoves(k: Int) {
        val ant = Ant(Grid())
        for (i in 1..k) {
            println("Step #$i:")
            ant.move()
            ant.flip()
            printGrid(ant)
            println("--------------------------------------------------------------------")
        }
    }

    private fun printGrid(ant: Ant) {
        for (row in ant.grid) {
            for (tile in row) {
                var toPrint = when (tile.color) {
                    TileColor.White -> 'W'
                    TileColor.Black -> 'B'
                }
                if (tile == ant.tile) {
                    toPrint = 'A'
                }
                print("[$toPrint]")
            }
            println()
        }
    }

    fun runTest() {
        printKMoves(25)
    }
}