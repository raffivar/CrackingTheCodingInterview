package chapter_16_moderate

class S25LRUCache {
    class LRU(private val maxSize: Int) {
        private val map = HashMap<Int, StringWithTimeStamp>()

        fun add(key: Int, value: String) {
            if (map.size == maxSize) {
                findOldest()?.let {
                    map.remove(findOldest())
                }
            }
            map[key] = StringWithTimeStamp(value)
        }

        private fun findOldest(): Int? {
            var minTimeStamp = Long.MAX_VALUE
            var oldestKey: Int? = null
            for (pair in map) {
                if (pair.value.timeStamp < minTimeStamp) {
                    minTimeStamp = pair.value.timeStamp
                    oldestKey = pair.key
                }
            }
            return oldestKey
        }

        fun printState() {
            for (pair in map) {
                println("${pair.key} -> ${pair.value.value}")
            }
        }

        private class StringWithTimeStamp(val value: String) {
            val timeStamp = System.currentTimeMillis()
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
        val cache = LRU(4)
        for (pair in pairs) {
            cache.add(pair.first, pair.second)
            println("current state:")
            cache.printState()
            println("--------------------------")
        }
    }
}