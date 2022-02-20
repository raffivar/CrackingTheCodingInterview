package chapter_16_moderate

class S22LagtonsAnt {
    enum class Direction { Top, Right, Bottom, Left }
    enum class Pivot { Clockwise, Counterclockwise }
    enum class TileColor { White, Black }
    class Tile(var color: TileColor) {
        var top: Tile? = null
        var bottom: Tile? = null
        var left: Tile? = null
        var right: Tile? = null
    }

    class Ant(var tile: Tile?) {
        var direction = Direction.Right

        fun walk() {
            when (this.direction) {
                Direction.Top -> this.tile = this.tile!!.top
                Direction.Right -> this.tile = this.tile!!.right
                Direction.Bottom -> this.tile = this.tile!!.bottom
                Direction.Left -> this.tile = this.tile!!.left
            }
            println("Walked $direction")
            if (this.tile == null) {
                println("Created new tile")
                this.tile = Tile(TileColor.White)
            }
        }

        fun flip() {
            when (this.tile!!.color) {
                TileColor.White -> {
                    TileColor.Black
                    rotate(Pivot.Clockwise)
                    println("From White to Black + Clockwise -> New direction is $direction")
                }
                TileColor.Black -> {
                    TileColor.White
                    rotate(Pivot.Counterclockwise)
                    println("From Black to White + Counter-Clockwise -> New direction is $direction")
                }
            }
        }

        private fun rotate(pivot: Pivot) {
            val direction = when (pivot) {
                Pivot.Clockwise -> +1
                Pivot.Counterclockwise -> -1
            }
            this.direction = Direction.values()[(this.direction.ordinal + direction) % Direction.values().size]
        }
    }

    private fun move(k: Int) {
        val ant = Ant(Tile(TileColor.White))
        for (i in 1..k) {
            ant.walk()
            ant.flip()
        }
    }

    fun runTest() {
        move(5)
        move(10)
    }
}