package chapter_6_math_and_logic

import Solution

class S10Poison : Solution {
    override fun runTest() {
        /**
         * Cycle #1
         * 1000 bottles divided to 10 strips (100 drops per strip) ->
         * 100 of them will come in positive
         *
         * Cycle #2
         * 99 bottles divided to 9 stripes (11 drops per strip) + 1 bottle left out ->
         * If all negative, the remaining bottle is the poison
         *
         * Cycle #3
         * 8 bottles divided to 8 strips (1 drop per strip) + 1 bottle left out ->
         * If all negative, the remaining bottle is the poison
         *
         * To conclude, it will take exactly either 14 or 21 days to find the poison.
         */
    }
}