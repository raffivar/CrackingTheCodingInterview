package chapter_1_arrays_and_strings

class S1IsUnique {
    private fun isUnique1(str: String): Boolean {
        val hasSet = hashSetOf<Char>()
        for (char in str) {
            if (hasSet.contains(char)) {
                return false
            }
            hasSet.add(char)
        }
        return true
    }

    fun runTest() {
        val val1 = "aaaa"
        val val2 = "abcd"
        println("isUnique1(\"$val1\"): ${isUnique1(val1)}")
        println("isUnique1(\"$val2\"): ${isUnique1(val2)}")
    }
}