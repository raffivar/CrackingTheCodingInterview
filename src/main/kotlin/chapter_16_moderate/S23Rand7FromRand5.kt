package chapter_16_moderate

import java.util.*

class S23Rand7FromRand5 {
    private fun rand7(): Int {
        var result = 0
        do {
            val newValue = result + rand5()
            if (newValue in 0..6) {
                result = newValue
            }
        } while (rollAgain())
        return result
    }

    /**
     * Flips coin
     * 0, 1 -> yes
     * 3, 4 -> no
     * 2 -> roll again
     */
    private fun rollAgain(): Boolean {
        return when (rand5()) {
            in 0..1 -> true
            in 3..4 -> false
            else -> rollAgain()
        }
    }

    private fun rand5(): Int {
        return Random().nextInt(5)
    }

    fun runTest() {
        for (i in 1..10) {
            println("rand7: ${rand7()}")
        }
    }
}