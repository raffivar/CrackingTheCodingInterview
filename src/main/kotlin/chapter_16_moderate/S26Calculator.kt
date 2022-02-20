package chapter_16_moderate

class S26Calculator {
    private fun calc(expression: String): Float {
        val result = convertToList(expression)

        //Cycle #1 -> [*, /]
        var i = 0
        while (i < result.lastIndex - 2) {
            when (val operator = result[i + 1]) {
                in firstPriority -> calc(result, operator as Char, i)
                else -> i += 2
            }
        }

        //Cycle #2 -> [+, -]
        i = 0
        while (i <= result.lastIndex - 2) {
            val operator = result[i + 1]
            calc(result, operator as Char, i)
        }

        return result[0] as Float
    }

    private fun calc(result: ArrayList<Any>, operator: Char, i: Int) {
        val num1 = result[i] as Float
        val num2 = result[i + 2] as Float
        val num = operations[operator]!!.invoke(num1, num2)
        for (j in 1..3) {
            result.removeAt(i)
        }
        result.add(i, num)
    }

    private fun convertToList(expression: String): ArrayList<Any> {
        val result = ArrayList<Any>()
        var i = 0
        var number = ""
        while (i < expression.length) {
            val char = expression[i]
            when {
                isPartOfNum(char) -> number += char
                else -> {
                    result.add(number.toFloat())
                    number = ""
                    result.add(char)
                }
            }
            i++
        }
        result.add(number.toFloat())
        return result
    }

    private val firstPriority = hashSetOf('*', '/')

    private val operations = hashMapOf(
        Pair('+', this::plus),
        Pair('-', this::minus),
        Pair('*', this::times),
        Pair('/', this::divide),
    )

    private fun isPartOfNum(char: Char): Boolean {
        return char.isDigit()
    }

    private fun plus(num1: Float, num2: Float): Float {
        return (num1 + num2)
    }

    private fun minus(num1: Float, num2: Float): Float {
        return (num1 - num2)
    }

    private fun times(num1: Float, num2: Float): Float {
        return (num1 * num2)
    }

    private fun divide(num1: Float, num2: Float): Float {
        return (num1 / num2)
    }

    fun runTest() {
        val testCases = arrayListOf(
            "2*3+5/6*3+15",
            "2+3*5/6*3+15",
            "2+3*5/0*3+15"
        )
        for (case in testCases) {
            println("$case = ${calc(case)}")
        }
    }
}