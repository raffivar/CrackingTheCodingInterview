package chapter_13_java

import Solution

class S1PrivateConstructor : Solution {
    override fun runTest() {
        /**
         * S1 - Private Constructor:
         * Q: In terms of inheritance, what is the effect of keeping a constructor private?
         * A: A private constructor can be used by:
         * 1. The inner classes of a class
         * 2. The inner classes of the that class's parent class
         * Note:
         * There are direct implications in terms of inheritance,
         * since the class's constructor calls the parent class's constructor
         *
         */
    }
}