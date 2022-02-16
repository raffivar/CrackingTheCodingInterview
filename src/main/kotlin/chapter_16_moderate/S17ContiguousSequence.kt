package chapter_16_moderate

class S17ContiguousSequence {
    private fun getMaxSum(array: IntArray): Int {
        val n = array.size
        val sumArray = ArrayList<Int>()
        var right = 0
        for (i in 1..n) {
            when (i) {
                1 -> { //first cycle
                    for (num in array) {
                        sumArray.add(num)
                    }
                }
                else -> {
                    val left = right
                    right = sumArray.size
                    for (j in 0..right - left) {
                        if (j + i - 1 < array.size) {
                            sumArray.add(sumArray[left + j] + array[j + i - 1])
                        }
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
        val testCases = arrayListOf(intArrayOf(2, -8, 3, -2, 4, -10))
        for (case in testCases) {
            println(Util.arrayAsString(case))
            println(getMaxSum(case))
        }
    }
}