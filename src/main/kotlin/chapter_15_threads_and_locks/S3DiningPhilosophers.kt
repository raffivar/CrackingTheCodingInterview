package chapter_15_threads_and_locks

class S3DiningPhilosophers {
    class Chopstick(val name: String)
    class Philosopher(
        var left: Chopstick?,
        val right: Chopstick?
    )

    class DiningTable(n: Int) {
        private val philosophers = arrayListOf<Philosopher>()

        init {
            for (i in 0 until n) {
                val philosopher = when (i) {
                    0 -> Philosopher(null, Chopstick("Chopstick #1"))
                    n - 1 -> Philosopher(philosophers[i - 1].right, Chopstick("Chopstick #0"))
                    else -> Philosopher(philosophers[i - 1].right, Chopstick("Chopstick #${i + 1}"))
                }
                philosophers.add(philosopher)
            }
            philosophers[0].left = philosophers.last().right
        }

        fun printState() {
            for ((i, p) in philosophers.withIndex()) {
                println("Philosopher #$i left: ${p.left?.name}")
                println("Philosopher #$i right: ${p.right?.name}")
                println("------------------------------------------------")
            }
        }
    }

    fun runTest() {
        val table = DiningTable(4)
        table.printState()
    }
}