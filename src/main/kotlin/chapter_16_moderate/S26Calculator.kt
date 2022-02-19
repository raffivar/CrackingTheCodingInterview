package chapter_16_moderate

class S26Calculator {
    private fun calc(expression: String): Int {
        return 0
    }

    private val cycle1Operators = hashSetOf('*', '/')
    private val cycle2Operators = hashSetOf('+', '-')

    private val operations = hashMapOf(
        Pair('+', this::plus),
        Pair('-', this::minus),
        Pair('*', this::times),
        Pair('/', this::divide),
    )

    private fun isPartOfNum(char: Char): Boolean {
        return char.isDigit()
    }

    private fun plus(num1: Int, num2: Int): Float {
        return (num1 + num2).toFloat()
    }

    private fun minus(num1: Int, num2: Int): Float {
        return (num1 - num2).toFloat()
    }

    private fun times(num1: Int, num2: Int): Float {
        return (num1 * num2).toFloat()
    }

    private fun divide(num1: Int, num2: Int): Float {
        return (num1 / num2).toFloat()
    }

    fun runTest() {
        val testCases = arrayListOf(
            "2*3+5/6*3+15",
            "2*3+5/6*3+15"
        )
        for (case in testCases) {
            println("$case = ${calc(case)}")
        }
    }
}