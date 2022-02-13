package chapter_16_moderate

class S5FactorialZero {
    private fun countFactZeros(n: Int): Int {
        var count =  0
        if (n < 0) {
            return -1
        }
        var i = 5
        while (n / i > 0)  {
            count += n / i
            i *= 5
        }
        return count

    }

    fun runTest() {
        val testCases = arrayListOf(1, 5, 10, 15, 20, 25, 27, 120, 121, 124, 125)
        for (case in testCases) {
            println("$case: ${countFactZeros(case)}")
        }
    }
}