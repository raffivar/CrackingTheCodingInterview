package chapter_16_moderate

class S17ContiguousSequence {
    private fun getMaxSum(array: IntArray): Int {
        val n = array.size

        val sumArray = ArrayList<Int>()
        var left = 0
        var right = 0

        for (i in 1..n) {
            if (i == 1) { //first cycle
                for (num in array) {
                    sumArray.add(num)
                }
                left = 0
                right = sumArray.size
            } else {
                val delta = right - left
                for (j in 0..delta) {
                    if (j + i - 1 < array.size) {
                        sumArray.add(sumArray[left + j] + array[j + i - 1])
                    }
                }
                left = right
                right = sumArray.size
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