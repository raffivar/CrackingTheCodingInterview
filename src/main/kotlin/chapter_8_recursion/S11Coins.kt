package chapter_8_recursion

class S11Coins {
    private fun possibleCoins(numOfCents: Int, possibleCoins: ArrayList<Int>): Int {
        return coins(0, numOfCents, possibleCoins)
    }

    private fun coins(current: Int, total: Int, possibleCoins: ArrayList<Int>): Int {
        if (current == total) {
            println("======================= REACHED SUM =========================")
            return 1
        }
        var options = 0
        for ((i, coin) in possibleCoins.withIndex()) {
            val subCoins = ArrayList(possibleCoins.slice(i..possibleCoins.lastIndex))
            val sum = current + coin
            if (sum <= total) {
                println("[$current/$total] -> [$sum/$total] -> added [$coin]")
                options += coins(sum, total, subCoins)
            }
        }
        return options
    }


    fun runTest() {
        val coins = arrayListOf(25, 10, 5, 1)
        val functions = arrayListOf(this::possibleCoins)
        val testCases = arrayListOf(
            Pair(15, coins),
            Pair(35, coins)
        )
        for (function in functions) {
            for (case in testCases) {
                println("------------------------------------------")
                println("stairs: ${case.first}")
                println("step sizes: ${case.second}")
                println("number of ways to represent [${case.first}] cents:  ${function(case.first, case.second)}")
            }
        }
    }
}