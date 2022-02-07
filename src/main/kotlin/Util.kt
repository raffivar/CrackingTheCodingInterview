import java.lang.StringBuilder

class Util {
    companion object {
        fun<T> Collection<T>.asString(): String {
            val sb = StringBuilder()
            for (element in this) {
                sb.append("$element, ")
            }
            return "[${sb.removeSuffix(", ")}]"
        }

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