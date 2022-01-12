package chapter_5_recursion

class S1TripleStep {
    private val total = 3 // for documenting purposes only

    private fun steps(n: Int, steps: ArrayList<Int>): Int {
        if (n == 0) { //num of steps left
            println("THE BOY FINISHED RUNNING UP THE STAIRS! :D")
            return 1
        }
        var options = 0
        for (step in steps) {
            if (n - step >= 0) {
                val before = total - n
                val after = before + step
                println("the boy takes $step step(s): $before/$total -> $after/$total")
                options += steps(n - step, steps)
            }
        }
        return options
    }

    fun runTest() {
        val functions = arrayListOf(this::steps)
        val testCases = arrayListOf(
            Pair(total, arrayListOf(1, 2, 3))
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