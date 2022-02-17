package chapter_16_moderate

class S25LRUCache {
    class LRU {
        private val map = HashMap<Int, String>()
        fun add(key: Int, value: String) {
            map[key] = value
        }
        fun printState() {
            for (pair in map) {
                println("${pair.key} -> ${pair.value}")
            }
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
        val cache = LRU()
        for (pair in pairs) {
            cache.add(pair.first, pair.second)
            println("current state:")
            cache.printState()
            println("--------------------------")
        }
    }
}