package chapter_16_moderate

import java.util.*
import kotlin.collections.HashMap

class S25LRUCache {
    class LRU(private val maxSize: Int) : HashMap<Int, String>() {
        private val queue: Queue<Int> = LinkedList()
        fun add(key: Int, value: String) {
            when {
                maxSize <= 0 -> return
                queue.size == maxSize && queue.isNotEmpty() -> this.remove(queue.remove())
            }
            queue.add(key)
            this[key] = value
        }
    }

    fun runTest() {
        val pairs = arrayListOf(
            Pair(1, "one"),
            Pair(2, "two"),
            Pair(3, "three"),
            Pair(4, "four"),
            Pair(5, "five"),
            Pair(6, "six"),
            Pair(7, "seven")
        )
        val cache = LRU(0)
        for (pair in pairs) {
            cache.add(pair.first, pair.second)
            println("current state:")
            for (entry in cache) {
                println("${entry.key} -> ${entry.value}")
            }
            println("--------------------------")
        }
    }
}