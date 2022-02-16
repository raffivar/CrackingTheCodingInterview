package chapter_16_moderate

class S17ContiguousSequence {
    private fun getMaxSum(array: IntArray): Int? {
        if (array.isEmpty()) {
            return null
        }
        val sumArray = ArrayList<Int>()
        //Copy the values themselves (each one counts as a sum by it's own)
        for (num in array) {
            sumArray.add(num)
        }
        //The rest of the calculations (more than 1 element per sum)
        var left = 0
        var right = sumArray.size
        for (i in 1..array.lastIndex) {
            var j = 0
            while (j < right - left && j + i < array.size) {
                sumArray.add(sumArray[left + j] + array[j + i])
                j++
            }
            left = right
            right = sumArray.size
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
            intArrayOf(2, 3),
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