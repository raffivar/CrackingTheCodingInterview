package chapter_13_java

import Solution

class S5TreeMapHashMapLinkedHashMap : Solution {
    override fun runTest() {
        /**
         * S5 - TreeMap, HashMap, LinkedHashMap:
         * Q:
         * Explain the differences between TreeMap, HashMap, and inkedHashMap.
         * Provide an example of when each one would be best.
         *
         * A:
         * HashMap:
         * Insertion + Lookup are O(1).
         * Iterating has an arbitrary order.
         * Implemented by an array of linked lists.
         * We'll use this unless we have a good reason not to.
         *
         * TreeMap:
         * Insertion + Lookup are O(log(n)).
         * Keys are ordered, which means two things:
         * 1. Iterating through the values is done is sorted order.
         * 2. You need to implemented the Comparable interface.
         * Implemented by a Red-Black tree.
         * We'll use it if we need, for example to
         * - Output people in an alphabetical order.
         * - Given a name, output the next 10 people
         *
         * LinkedHashMap:
         * Insertion + Lookup are O(1).
         * Keys are ordered by their insertion.
         * Implemented by doubly-linked buckets
         * We'll use this when, for example,
         * when we have a caching situation,
         * and we want to delete the oldest item.
         *
         */
    }
}