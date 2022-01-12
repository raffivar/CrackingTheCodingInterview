package chapter_5_recursion

class S4PowerSet {
    private fun powerSet(set: Set<Int>): Set<Set<Int>> {
        return setOf()
    }
    
    fun runTest() {
        val functions = arrayListOf(this::powerSet)
        val testCases = arrayListOf(
            setOf(1, 2, 3, 4, 5)
        )
        for (function in functions) {
            for (case in testCases) {
                println("------------------------------------------")
                println("Set: $case")
                println("All sub-sets: ${function(case)}")
                println("------------------------------------------")
            }
        }
    }
}