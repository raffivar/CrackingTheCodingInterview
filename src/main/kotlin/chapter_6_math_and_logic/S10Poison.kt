package chapter_6_math_and_logic

import Solution

class S10Poison : Solution {
    private class Bottle(val id: Int, val isPoisoned: Boolean)
    private class Strip(val id: Int) {
        fun addDropOnDay(day: Int, bottle: Bottle) {
            //Add drop
        }

        fun isPositiveOnDay(day: Int): Boolean {
            return false
        }
    }

    private fun findPoisonedBottle(bottles: ArrayList<Bottle>, strips: ArrayList<Strip>) {
        for (bottle in bottles) {
            var id = bottle.id
            var bitIndex = 0
            while (id > 0) {
                if ((id and 1) == 1) {
                    strips[bitIndex].addDropOnDay(0, bottle)
                }
                bitIndex++
                id = id.shr(1)
            }
        }
    }

    private fun runPositiveOnDay(strips: ArrayList<Strip>, day: Int): ArrayList<Int> {
        val positive = ArrayList<Int>()
        for (strip in strips) {
            val id = strip.id
            if (strip.isPositiveOnDay(day)) {
                positive.add(id)
            }
        }
        return positive
    }

    private fun setBits(positive: ArrayList<Int>): Int {
        var id = 0
        for (bitIndex in positive) {
            id = id or 1.shl(bitIndex)
        }
        return id
    }

    override fun runTest() {
        /**TODO: implement simulation*/
    }
}