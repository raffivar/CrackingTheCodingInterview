package chapter_13_java

class S7LambdaExpressions {
    /**
     * S7 - Lambda Expressions:
     * Q: There is a class Country that has methods getContinent() and
     * getPopulation(). Write a function int getPopulation(List<Country> countries,
     * String continent) that computes the total population of a given continent, given a list of all
     * countries and the name of a continent.
     *
     */
    class Country(
        val population: Int,
        val continent: String
        )

    fun getPopulation(countries: List<Country>, continent: String): Int {
        var sum = 0
        for (c in countries) {
            if (c.continent == continent) {
                sum += c.population
            }
        }
        return sum
    }

    fun getPopulationLambda(countries: List<Country>, continent: String): Int {
        //Filter countries
        val sublist = countries.stream().filter { country: Country -> country.continent == continent }
        //Convert to list of populations
        val populations = sublist.map { c: Country -> c.population }
        //Return the sum
        return populations.reduce(0) { a: Int, b: Int -> a + b }
    }
}

