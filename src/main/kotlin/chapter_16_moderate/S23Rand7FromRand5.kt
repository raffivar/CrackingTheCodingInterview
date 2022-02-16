package chapter_16_moderate

import java.util.*

class S23Rand7FromRand5 {
    private fun rand7(): Int {
        var result = 0
        do {
            when (val newValue = result + rand5()){
                in 0..6 -> result = newValue
                else -> break
            }
            val ifContinue = rand5() + rand5()
        } while (ifContinue in 0..4) //0..4 -> continue // 5..9 -> don't

        return result
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