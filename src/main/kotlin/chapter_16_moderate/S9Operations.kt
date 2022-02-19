package chapter_16_moderate

class S9Operations {
    private fun subtract(a: Int, b: Int): Int {
        return 0
    }

    private fun multiply(a: Int, b: Int): Int {
        return 0
    }

    private fun divide(a: Int, b: Int): Int {
        return 0
    }

    fun runTest() {
        val testCases = arrayListOf(
            Pair(5, 10),
            Pair(7, 3),
            Pair(4, -1),
            Pair(3, 1),
            Pair(13, 22),
            Pair(-6, -10),
            Pair(-5, 18)
        )
        for (case in testCases) {
            println("${case.first} - ${case.second} = ${subtract(case.first, case.second)}")
            println("${case.first} * ${case.second} = ${multiply(case.first, case.second)}")
            println("${case.first} / ${case.second} = ${divide(case.first, case.second)}")
            println("------------------------")
        }
    }
}