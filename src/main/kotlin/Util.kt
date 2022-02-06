import java.lang.StringBuilder

class Util {
    companion object {
        fun arrayAsString(array: Array<Int>): String {
            val sb = StringBuilder()
            for (num in array) {
                sb.append("$num, ")
            }
            return "[${sb.removeSuffix(", ")}]"
        }

        fun arrayAsString(array: IntArray): String {
            val sb = StringBuilder()
            for (num in array) {
                sb.append("$num, ")
            }
            return "[${sb.removeSuffix(", ")}]"
        }
    }
}