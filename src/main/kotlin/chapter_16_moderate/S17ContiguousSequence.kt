package chapter_16_moderate

import Solution

class S17ContiguousSequence : Solution {
    private fun getMaxSum(array: IntArray): Int? {
        if (array.isEmpty()) {
            return null
        }
        var maxSum = Int.MIN_VALUE
        val sumArray = ArrayList<Int>()
        //Copy the values themselves (each one counts as a sum by its own)
        for (num in array) {
            if (num > maxSum) {
                maxSum = num
            }
            sumArray.add(num)
        }
        //The rest of the calculations (more than 1 element per sum)
        var start = 0
        for (i in 1..array.lastIndex) {
            for (j in 0..array.lastIndex - i) {
                val sum = sumArray[start + j] + array[i + j]
                if (sum > maxSum) {
                    maxSum = sum
                }
                sumArray.add(sum)
            }
            start = sumArray.size - array.size + i
        }
        return maxSum
    }

    override fun runTest() {
        val testCases = arrayListOf(
            intArrayOf(2, -8, 3, -2, 4, -10),
            intArrayOf(2, 3, -4, 21),
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