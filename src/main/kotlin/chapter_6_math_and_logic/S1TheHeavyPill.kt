package chapter_6_math_and_logic

class S1TheHeavyPill {
    private fun findHeavyBottle(bottles: ArrayList<Float>) {
        var supposedSum = 0f
        var actualSum = 0f
        for ((i, bottle) in bottles.withIndex()) {
            supposedSum += (i + 1) * 1.0f
            actualSum += (i + 1) * bottle
        }
        println("bottles: ${bottles.size}")
        println("supposed sum: $supposedSum")
        println("actual sum: $actualSum")
        println("fake bottle: bottle #${(actualSum * 10 - supposedSum * 10).toInt()}")
    }

    fun runTest() {
        val bottles = arrayListOf(1f, 1f, 1f, 1f, 1f, 1f, 1.1f, 1f, 1f, 1f)
        findHeavyBottle(bottles)
    }
}