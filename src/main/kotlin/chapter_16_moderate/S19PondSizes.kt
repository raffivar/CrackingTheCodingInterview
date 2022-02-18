package chapter_16_moderate

import Util.Companion.asString

class S19PondSizes {
    private fun getPondSizes(land: Array<IntArray>): ArrayList<Int> {
        val result = ArrayList<Int>()
        return result
    }

    fun runTest() {
        val land = arrayOf(
            intArrayOf(0, 2, 1, 0),
            intArrayOf(0, 1, 0, 1),
            intArrayOf(1, 1, 0, 1),
            intArrayOf(0, 1, 0, 1)
        )

        println("land:\n${Util.matrixAsString(land)}")
        println("pond sizes: ${getPondSizes(land).asString()}")
    }
}