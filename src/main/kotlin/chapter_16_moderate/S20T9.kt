package chapter_16_moderate

class S20T9 {
    private val dictionary = Dictionary.words.split(", ")
    private val digitToLetters = hashMapOf(
        Pair('0', ""),
        Pair('1', ""),
        Pair('2', "abc"),
        Pair('3', "def"),
        Pair('4', "ghi"),
        Pair('5', "jkl"),
        Pair('6', "mno"),
        Pair('7', "pqrs"),
        Pair('8', "tuv"),
        Pair('9', "wxyz")
    )

    private fun getPossibleWords(digits: String): ArrayList<String> {
        val words = ArrayList<String>()
        populate(words, "", digits)
        return words
    }

    private fun populate(words: ArrayList<String>, word: String, digits: String) {
        if (digits.isBlank()) {
            if (dictionary.contains(word)) {
                words.add(word)
            }
            return
        }
        val digit = digits[0]
        val letters = digitToLetters[digit]
        for (letter in letters!!.toCharArray()) {
            val wordSoFar = word + letter
            populate(words, wordSoFar, digits.substring(1))
        }
    }

    fun runTest() {
        val testCases = arrayListOf("8733", "7363")
        for (case in testCases) {
            println("$case:")
            for ((i, word) in getPossibleWords(case).withIndex()) {
                print("${i + 1}. $word\n")
            }
            println()
        }
    }
}