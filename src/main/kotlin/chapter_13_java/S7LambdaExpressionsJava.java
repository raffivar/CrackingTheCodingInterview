package chapter_13_java;

import java.util.List;
import java.util.stream.Stream;

public class S7LambdaExpressionsJava {
    class Country {
        int population;
        String continent;

        public int getPopulation() {
            return population;
        }

        public String getContinent() {
            return continent;
        }

        public Country(int population, String continent) {
            this.population = population;
        }
    }

    int getPopulation(List<Country> countries, String continent) {
        int sum = 0;
        for (Country c : countries) {
            if (c.getContinent().equals(continent)) {
                sum += c.getPopulation();
            }
        }
        return sum;
    }

    int getPopulationLambda(List<Country> countries, String continent) {
        //Filter countries
        Stream<Country> sublist = countries.stream().filter(
                country -> { return country.getContinent().equals(continent); }
        );

        //Convert to list of populations
        Stream<Integer> populations = sublist.map(
                c -> c.getPopulation()
        );

        //Sum list
        int population = populations.reduce(0, (a, b) -> a + b);

        //Return population
        return population;
    }
}
