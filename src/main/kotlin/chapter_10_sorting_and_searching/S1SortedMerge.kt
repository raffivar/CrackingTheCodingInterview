package chapter_10_sorting_and_searching

class S1SortedMerge {
    private fun sortedMerge(a: IntArray, b: IntArray) {
        var k = a.lastIndex
        var i = findEndOfElements(a)
        var j = b.lastIndex

        while (j >= 0 && i >= 0) { //sort everything to the end of buffer
            when {
                a[i] > b[j] -> {
                    swap(a, i, k)
                    i--
                }
                else -> {
                    a[k] = b[j]
                    j--
                }
            }
            k--
        }

        while (j >= 0) { //handle elements left in b, if any
            a[k] = b[j]
            j--
            k--
        }

        println("a + b [before moving to beginning]: ${Util.arrayAsString(a)}")
        while (k < a.lastIndex) { //handle elements left in a, if any (copy everything from end of buffer to the end of current values in a)
            i++
            k++
            swap(a, i, k)
        }
        println("a + b [after moving to beginning]: ${Util.arrayAsString(a)}")
    }

    private fun findEndOfElements(array: IntArray): Int {
        var i = 0
        while (i + 1 < array.size && array[i + 1] != -1) {
            i++
        }
        return i
    }

    private fun swap(array: IntArray, i: Int, j: Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }

    fun runTest() {
        val testCases = arrayListOf(
            Pair(
                intArrayOf(1, 3, 6, 9, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
                intArrayOf(2, 5, 6, 8, 12)
            ),
            Pair(
                intArrayOf(1, 2, 3, 6, 9, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
                intArrayOf(4, 5, 6, 8, 12)
            ),
            Pair(
                intArrayOf(10, 11, 12, 13, 14, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1),
                intArrayOf(1, 2, 3, 5, 6)
            )
        )
        for (case in testCases) {
            val a = case.first
            val b = case.second
            println("a: ${Util.arrayAsString(a)}")
            println("b: ${Util.arrayAsString(b)}")
            sortedMerge(a, b)
            println()
        }
    }
}