package chapter_16_moderate

import Solution

class S1NumberSwapper : Solution {
    override fun runTest() {
        var x = 10
        var y = 20
        println("Before:")
        println("x = $x")
        println("y = $y")
        x += y
        y = x - y
        x -= y
        println("After:")
        println("x = $x")
        println("y = $y")
    }
}