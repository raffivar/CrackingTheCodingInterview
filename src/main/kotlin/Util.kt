import java.lang.StringBuilder

class Util {
    companion object {
        fun String.sorted() = String(toCharArray().apply { sort() })

        fun <T> swap(array: Array<T>, i: Int, j: Int) {
            val temp = array[i]
            array[i] = array[j]
            array[j] = temp
        }

        fun swap(array: IntArray, i: Int, j: Int) {
            val temp = array[i]
            array[i] = array[j]
            array[j] = temp
        }

        fun <T> Collection<T>.asString(): String {
            val sb = StringBuilder()
            for (element in this) {
                sb.append("$element, ")
            }
            return "[${sb.removeSuffix(", ")}]"
        }

        fun <T> arrayAsString(array: Array<T>): String {
            val sb = StringBuilder()
            for (num in array) {
                sb.append("$num, ")
            }
            return "[${sb.removeSuffix(", ")}]"
        }

        fun matrixAsString(matrix: Array<IntArray>): String {
            val sb = StringBuilder()
            for (array in matrix) {
                sb.append("${arrayAsString(array)}\n")
            }
            return sb.substring(0, sb.length - 1)
        }

        fun arrayAsString(array: IntArray): String {
            val sb = StringBuilder()
            for (num in array) {
                sb.append("$num, ")
            }
            return "[${sb.removeSuffix(", ")}]"
        }

        fun sumArray(array: IntArray): Int {
            var sum = 0
            for (num in array) {
                sum += num
            }
            return sum
        }
    }
}