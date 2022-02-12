package chapter_13_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class S8LambdaRandomJava {
    List<Integer> getRandomSubset(List<Integer> list) {
        List<Integer> subset = new ArrayList<>();
        Random random = new Random();
        for (int item : list) {
            if (random.nextBoolean()) {
                subset.add(item);
            }
        }
        return subset;
    }

    List<Integer> getRandomSubsetLambda1(List<Integer> list) {
        Random random = new Random();
        List<Integer> subset = list.stream().filter(
                k -> { return random.nextBoolean(); }
        ).collect(Collectors.toList());
        return subset;
    }

    Random random = new Random();
    Predicate<Object> flipCoin = o -> {
        return random.nextBoolean();
    };

    List<Integer> getRandomSubsetLambda2(List<Integer> list) {
        List<Integer> subset = list.stream().filter(flipCoin).collect(Collectors.toList());
        return subset;
    }
}
