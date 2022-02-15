package chapter_16_moderate

class S17ContiguousSequence {
    private fun getMaxSum(array: IntArray): Int {
        val arraySum = sumArray(array)
        val sums = arrayListOf<Int>()
        populateSums(sums, array, arraySum)
        var max = Int.MIN_VALUE
        for (sum in sums) {
            if (sum > max) {
                max = sum
            }
        }
        return max
    }

    private fun populateSums(sums: ArrayList<Int>, array: IntArray, sum: Int) {
        if (array.isEmpty()) {
            return
        }
        sums.add(sum)
        val sumLeft = sum - array[array.lastIndex]
        val left = array.slice(0 until array.lastIndex).toIntArray()
        populateSums(sums, left, sumLeft)
        val sumRight = sum - array[0]
        val right = array.slice(1..array.lastIndex).toIntArray()
        populateSums(sums, right, sumRight)
    }

    private fun sumArray(array: IntArray): Int {
        var sum = 0
        for (num in array) {
            sum += num
        }
        return sum
    }

    fun runTest() {
        val testCases = arrayListOf(intArrayOf(2, -8, 3, -2, 4, -10))
        for (case in testCases) {
            println(Util.arrayAsString(case))
            println(getMaxSum(case))
        }
    }
}