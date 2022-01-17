package chapter_8_recursion

class S1TripleStep {
    private fun tripleSteps(numOfStairs: Int, possibleSteps: ArrayList<Int>): Int {
        return steps(0, numOfStairs, possibleSteps)
    }

    private fun steps(current: Int, total: Int, steps: ArrayList<Int>): Int {
        if (current == total) {
            println("THE BOY FINISHED RUNNING UP THE STAIRS! :D")
            return 1
        }
        var options = 0
        for (step in steps) {
            val after = current + step
            if (after <= total) {
                println("[$current/$total] -> [$after/$total] -> the boy took $step step(s)")
                options += steps(after, total, steps)
            }
        }
        return options
    }

    fun runTest() {
        val functions = arrayListOf(this::tripleSteps)
        val testCases = arrayListOf(
            Pair(3, arrayListOf(1, 2, 3))
        )
        for (function in functions) {
            for (case in testCases) {
                println("------------------------------------------")
                println("stairs: ${case.first}")
                println("step sizes: ${case.second}")
                println("options to go up the stairs: ${function(case.first, case.second)}")
                println("------------------------------------------")
            }
        }
    }
}