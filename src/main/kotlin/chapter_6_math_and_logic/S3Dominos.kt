package chapter_6_math_and_logic

import Solution

class S3Dominos : Solution {
    override fun runTest() {
        /**
         * The board initially has 64 tiles.
         * We take out two opposite diagonal tiles, and remain with 62 tiles.
         * We have 31 domino pieces, each covers two tiles.
         * Each one of the domino pieces should cover 1 black tile and 1 white tile.
         * However, we removed two pieces of the same color.
         * Hence, it's impossible.
         */
    }
}