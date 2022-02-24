package chapter_10_sorting_and_searching

import Solution

class S6SortBigFile : Solution {
    override fun runTest() {
        /**
         * Let x be the amount of memory we are given to work with
         * 1. Divide the file into chunks, which are x megabytes each
         * Each chunk is sorted separately and then saved back to the file system
         * 2. Once all the chunks are sorted, we merge the chunks, one by one.
         * At the end, we have a fully sorted file.
         *
         * This algorithm is known as external sort.
         */    }
}