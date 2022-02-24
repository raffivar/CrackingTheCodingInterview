package chapter_16_moderate

import Solution
import java.util.*
import kotlin.collections.HashMap

class S2WordFrequencies : Solution {
    private val book = arrayOf("this", "is", "my", "book", "and", "it", "is", "stored", "in", "my", "array")

    //Only 1 time
    private fun getFrequency(book: Array<String>, word: String): Int {
        val trimmedWord = word.trim().lowercase(Locale.getDefault())
        var count = 0
        for (currentWord in book) {
            if (currentWord.trim().lowercase(Locale.getDefault()) == trimmedWord) {
                count++
            }
        }
        return count
    }

    //Several times
    private val table = setupTable(book)

    private fun setupTable(book: Array<String>): HashMap<String, Int> {
        val table = HashMap<String, Int>()
        for (currentWord in book) {
            val trimmedWord = currentWord.trim().lowercase(Locale.getDefault())
            if (trimmedWord.isNotBlank()) {
                when (table.contains(trimmedWord)) {
                    true -> table[trimmedWord] = table[trimmedWord]!! + 1
                    false -> table[trimmedWord] = 1
                }
            }
        }
        return table
    }

    private fun getFrequencyRepeatable(book: Array<String>, word: String): Int {
        val trimmedWord = word.trim().lowercase(Locale.getDefault())
        return table[trimmedWord] ?: return 0
    }

    override fun runTest() {
        println("using 1st method:")
        println("is -> ${getFrequency(book, "is")}")
        println("in -> ${getFrequency(book, "in")}")
        println("my -> ${getFrequency(book, "my")}")
        println("not -> ${getFrequency(book, "not")}")
        println("using 2st method:")
        println("is -> ${getFrequencyRepeatable(book, "is")}")
        println("in -> ${getFrequencyRepeatable(book, "in")}")
        println("my -> ${getFrequencyRepeatable(book, "my")}")
        println("not -> ${getFrequencyRepeatable(book, "not")}")
    }
}