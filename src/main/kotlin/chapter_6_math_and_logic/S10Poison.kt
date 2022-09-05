package chapter_6_math_and_logic

import Solution
import java.util.*
import kotlin.collections.ArrayList

class S10Poison : Solution {
    private class Bottle(val id: Int, var isPoisoned: Boolean = false)
    private class Strip(val id: Int) {
        var isPositiveOnDay = -1
            private set

        private fun isAlreadyPositive(): Boolean {
            return isPositiveOnDay > -1
        }

        fun addDropOnDay(day: Int, bottle: Bottle) {
            when {
                this.isAlreadyPositive() -> return
                bottle.isPoisoned -> Random().nextInt(7 - day) + day
            }
        }

        fun isPositiveOnDay(day: Int): Boolean {
            return day >= isPositiveOnDay
        }
    }

    private fun findPoisonedBottle(bottles: ArrayList<Bottle>, strips: ArrayList<Strip>): Int {
        runTests(bottles, strips)
        val positive = getPositiveOnDay(strips, 7)
        return setBits(positive)
    }

    private fun runTests(bottles: ArrayList<Bottle>, strips: ArrayList<Strip>) {
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

    private fun getPositiveOnDay(strips: ArrayList<Strip>, day: Int): ArrayList<Int> {
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
            id = id or (1.shl(bitIndex))
        }
        return id
    }

    override fun runTest() {
        //Bottles
        val n = 1000
        val bottles = ArrayList<Bottle>()
        for (i in 0 until n) {
            bottles.add((Bottle(i)))
        }
        val poisonedId = Random().nextInt(n)
        bottles[poisonedId].isPoisoned = true

        //Strips
        val strips = ArrayList<Strip>()
        for (i in 0 until 10) {
            strips.add((Strip(i)))
        }

        //Find
        println("The real poisoned bottle: $poisonedId")
        println("The bottle that the function found: ${findPoisonedBottle(bottles, strips)}")
    }
}
