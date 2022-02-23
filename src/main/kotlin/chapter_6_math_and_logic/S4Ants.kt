package chapter_6_math_and_logic

import Solution

class S4Ants : Solution {
    override fun runTest() {
        /**
         * What we need to do is to take the chances of NOT colliding,
         * Then to subtract that from 100%
         * There are exactly two scenarios of ants not colliding:
         * 1. All ants go "left"
         * 2. All ants go "right"
         * if n is the number of sides/vertexes, the calculation would be:
         * ((0.5) ^ n) /*left*/ + ((0.5) ^ n) /*right*/ =>
         * 2 * (0.5 ^ n) =>
         * 2 * 0.5 * (0.5 ^ (n-1)) =>
         * 0.5 ^ (n-1)
         * And therefore, the final result (of ants to COLLIDE) would be:
         * 1 - (0.5 ^ (n - 1))
         */
    }
}