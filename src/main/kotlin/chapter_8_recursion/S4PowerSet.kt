package chapter_8_recursion

import Solution

class S4PowerSet : Solution {
    private fun powerSet(set: Set<Int>): Set<Set<Int>> {
        return powerSetRecursion(set, mutableSetOf())
    }

    private fun powerSetRecursion(set: Set<Int>, powerSet: MutableSet<Set<Int>>): Set<Set<Int>> {
        if (!powerSet.contains(set)) {
            powerSet.add(set)
        }
        for (num in set) {
            val mutableSet = set.toMutableSet()
            mutableSet.remove(num)
            powerSetRecursion(mutableSet, powerSet)
        }
        return powerSet
    }

    override fun runTest() {
        val functions = arrayListOf(this::powerSet)
        val testCases = arrayListOf(
            setOf(1, 2),
            setOf(1, 2, 3),
        )
        for (function in functions) {
            for (case in testCases) {
                println("------------------------------------------")
                println("Set:\n$case\n")
                println("All sub-sets:")
                printPowerSet(function(case))
            }
        }
    }

    private fun printPowerSet(powerSet: Set<Set<Int>>) {
        for (set in powerSet) {
            println(set)
        }
    }
}