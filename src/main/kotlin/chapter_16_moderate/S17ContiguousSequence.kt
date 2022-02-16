package chapter_16_moderate

class S17ContiguousSequence {
    private fun getMaxSum(array: IntArray): Int? {
        if (array.isEmpty()) {
            return null
        }
        val sumArray = ArrayList<Int>()
        var right = 0
        for (i in 0..array.lastIndex) {
            when (i) {
                0 -> { //first cycle
                    for (num in array) {
                        sumArray.add(num)
                    }
                }
                else -> {
                    val left = right
                    right = sumArray.size
                    var j = 0
                    while (j < right - left && j + i < array.size) {
                        sumArray.add(sumArray[left + j] + array[j + i])
                        j++
                    }
                }
            }
        }

        var maxSum = Int.MIN_VALUE
        for (sum in sumArray) {
            if (sum > maxSum) {
                maxSum = sum
            }
        }

        return maxSum
    }

    fun runTest() {
        val testCases = arrayListOf(
            intArrayOf(2, -8, 3, -2, 4, -10),
            intArrayOf(2),
            intArrayOf()
        )
        for (case in testCases) {
            println(Util.arrayAsString(case))
            println(getMaxSum(case))
            println("--------------------------------------")
        }
    }
}