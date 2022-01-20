package chapter_6_math_and_logic

class S7Apocalypse {
    /**
     * In a world with n families -
     * Cycle #1
     * n/2 (on average) will have girls
     * n/2 (on average) will have boys
     * Cycle #2
     * We take the families who had boys (n/2) -
     * (n/2)/2 (on average) will have girls
     * (n/2)/2 (on average) will have boys
     * and so on ans so forth until the result is 0
     * in any case, the final result is 50/50
     */

    class Genders(val girls: Float, val boys: Float)

    private fun calculate(n: Int): Genders { //n = number of families
        if (n == 1) {
            return Genders(0.5f, 0.5f)
        }
        val girls = n / 2 + calculate(n / 2).girls
        val boys = n / 2 + calculate(n / 2).boys
        return (Genders(girls, boys))
    }

    fun runTest() {
        val result = calculate(20)
        println("Kingdom #1:")
        println("Boys: ${result.boys}")
        println("Girls: ${result.girls}")
        println("-----------------------------")
    }
}