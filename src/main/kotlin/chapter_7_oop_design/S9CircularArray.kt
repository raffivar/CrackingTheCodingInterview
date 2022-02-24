package chapter_7_oop_design

import Solution
import kotlin.collections.ArrayList

class S9CircularArray : Solution {
    class CircularArray<T> : ArrayList<T>() {
        fun rotateLeft() {
            val obj = this.removeFirst()
            this.add(obj)
        }

        fun rotateRight() {
            val obj = this.removeLast()
            this.add(0, obj)
        }
    }

    override fun runTest() {
        val numbers = CircularArray<Int>()
        for (i in 1..5) {
            numbers.add(i)
        }
        println("Before - $numbers")
        numbers.rotateLeft()
        println("Rotate left - $numbers")
        numbers.rotateRight()
        numbers.rotateRight()
        println("Rotate right [x2] - $numbers")
    }
}