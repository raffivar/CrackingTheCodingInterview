package chapter_16_moderate

class S10LivingPeople {
    private fun getMaxYear(people: ArrayList<Person>): Int {
        return 0
    }

    private class Person(
        val birth: Int,
        val death: Int
    )

    fun runTest() {
        val people = arrayListOf(
            Person(1905, 2000),
            Person(1800, 1915),
            Person(1817, 1917),
            Person(1815, 1938),
        )
        for (person in people) {
            println("[${person.birth}, ${person.death}]")
        }
        println("First year with most people alive: [${getMaxYear(people)}]")
    }
}