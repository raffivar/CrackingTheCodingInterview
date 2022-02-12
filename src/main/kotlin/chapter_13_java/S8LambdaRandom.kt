package chapter_13_java

import java.util.*
import java.util.function.Predicate
import java.util.stream.Collectors

class S8LambdaRandom {
    /**
     * S8 - Lambda Random:
     * Q: Using lambda expressions, write a function List<Integer>getRandomSubset(List<Integer> list)
     * that returns a random subset of arbitrary size.
     * All subsets (including the empty set) should be equally likely to be chosen
     *
     * A:
     * We might be tempted to choose a number between 0 and n,
     * and create a random subset based on that.
     * This creates two issues:
     * 1. if n > 1, there are more subsets of n/2 than of n.
     * 2. it's actually easier to generate a subset of any size, rather than a fixed size.
     * The fact that we're told to use lambdas is a hint.
     * We can actually iterate over the entire list and "flip a coin",
     * in order to determine whether or not this item will be included in the subset
     *
     */

    fun getRandomSubset(list: List<Int>): MutableList<Int> {
        val subset: MutableList<Int> = ArrayList()
        val random = Random()
        for (item in list) {
            if (random.nextBoolean()) {
                subset.add(item)
            }
        }
        return subset
    }

    fun getRandomSubsetLambda1(list: List<Int?>): List<Int?>? {
        val random = Random()
        return list.stream().filter { random.nextBoolean() }.collect(Collectors.toList())
    }

    var random = Random()
    var flipCoin = Predicate { o: Any? -> random.nextBoolean() }
    fun getRandomSubsetLambda2(list: List<Int>): List<Int>? {
        return list.stream().filter(flipCoin).collect(Collectors.toList())
    }
}

