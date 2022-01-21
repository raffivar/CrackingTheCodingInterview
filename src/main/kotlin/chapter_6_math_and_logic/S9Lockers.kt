package chapter_6_math_and_logic

class S9Lockers {
    /**
     * If the locker number has an even number of dividers (including 1 and itself), it's closed
     * Otherwise, it's open
     */

    private fun calculateLockers(lockers: Int) {
        var closed = 0
        var open = 0

        for (i in 1..lockers) {
            when (numOfDividers(i) % 2) {
                0 -> closed++
                else -> open++
            }
        }

        println("Number of closed lockers at the end: $closed")
        println("Number of open lockers at the end: $open")
    }

    private fun numOfDividers(n: Int): Int {
        var numOfDividers = 0
        for (i in 1..n) {
            if (n % i == 0) {
                numOfDividers++
            }
        }
        return numOfDividers
    }

    fun runTest() {
        calculateLockers(100)
    }
}