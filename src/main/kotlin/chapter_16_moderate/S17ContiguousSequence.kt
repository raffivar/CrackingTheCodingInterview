package chapter_16_moderate

class S17ContiguousSequence {
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
        var left = 0
        var right = sumArray.size
        for (i in 1..array.lastIndex) {
            var j = 0
            while (j < right - left && j + i < array.size) {
                val sum = sumArray[left + j] + array[j + i]
                if (sum > maxSum) {
                    maxSum = sum
                }
                sumArray.add(sum)
                j++
            }
            left = right
            right = sumArray.size
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