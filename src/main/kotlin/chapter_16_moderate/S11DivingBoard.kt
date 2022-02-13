package chapter_16_moderate

class S11DivingBoard {
    private fun getLengths(k: Int, shorter: Int, longer: Int): ArrayList<Int> {
        val lengths = ArrayList<Int>()
        for (i in 0..k) {
            lengths.add(longer * (k - i) + shorter * i)
        }
        return lengths
    }

    fun runTest() {
        val testCases = arrayListOf(
            Triple(10, 1, 2),
        )
        for (case in testCases) {
            val k = case.first
            val shorter = case.second
            val longer = case.third
            val lengths = getLengths(k, shorter, longer)
            println("[$k, $shorter, $longer] -> $lengths")
        }
    }
}