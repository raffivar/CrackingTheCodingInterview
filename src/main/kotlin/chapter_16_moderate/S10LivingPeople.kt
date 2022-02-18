package chapter_16_moderate

import chapter_10_sorting_and_searching.sorting.Sorting

class S10LivingPeople {
    private fun getMaxYear(people: ArrayList<Person>): Int {
        val yearPopulations = HashMap<Int, Int>()
        for (person in people) {
            when (val birth = yearPopulations[person.birth]) {
                null -> yearPopulations[person.birth] = 1
                else -> yearPopulations[person.birth] = birth + 1
            }
            when (val death = yearPopulations[person.death]) {
                null -> yearPopulations[person.death + 1] = -1
                else -> yearPopulations[person.death + 1] = death - 1
            }
        }
        val years = yearPopulations.keys.toIntArray()
        Sorting.sort(years)
        var sum = 0
        var maxSum = 0
        var maxYear = 1899
        for (year in years) {
            sum += yearPopulations[year]!!
            if (sum > maxSum) {
                maxSum = sum
                maxYear = year
            }
        }
        return maxYear
    }

    private class Person(
        val birth: Int,
        val death: Int
    )

    fun runTest() {
        val people = arrayListOf(
            Person(1900, 1907),
            Person(1904, 1915),
            Person(1930, 1987),
            Person(1934, 1945),
            Person(1942, 2000),
        )
        for (person in people) {
            println("[${person.birth}, ${person.death}]")
        }
        println("First year with most people alive: [${getMaxYear(people)}]")
    }
}