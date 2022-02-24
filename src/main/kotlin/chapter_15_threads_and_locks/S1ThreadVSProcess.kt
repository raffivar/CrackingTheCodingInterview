package chapter_15_threads_and_locks

import Solution

class S1ThreadVSProcess : Solution {
    override fun runTest() {
        /**
         * Question:
         * What is the difference between a thread and a process?
         *
         * Answer:
         * Processes are separate units of program.
         * Each process  is executed in a separate address space.
         * They cannot access each other's resources unless done explicitly,
         * by using pipes, files, sockets, etc.
         *
         * A process can contain several threads.
         * A thread exists within a process and shares the process' resource (including heap space).
         * Multiple threads within the same process will share the same heap space.
         * Each thread still has its own registers and its own stack,
         * but other thread can read and write the heap memory.
         *
         */
    }
}