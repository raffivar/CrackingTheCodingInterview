package chapter_16_moderate

class S17ContiguousSequence {
    private fun getMaxSum(array: IntArray): Int {
        val n = array.size
        val sumMap = HashMap<Int, ArrayList<Int>>()
        for (i in 1..n) {
            sumMap[i] = arrayListOf()
            val previousSums = sumMap[i - 1]
            if (previousSums == null) { //first cycle
                for (num in array) {
                    sumMap[i]!!.add(num)
                }
            } else {
                for ((j, num) in previousSums.withIndex()) {
                    if (j + i - 1 < array.size) {
                        sumMap[i]!!.add(num + array[j + i - 1])
                    }
                }
            }
        }
        var maxSum = Int.MIN_VALUE
        for (sums in sumMap.values) {
            for (sum in sums) {
                if (sum > maxSum) {
                    maxSum = sum
                }
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