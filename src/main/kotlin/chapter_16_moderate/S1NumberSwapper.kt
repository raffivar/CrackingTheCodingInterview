package chapter_16_moderate

class S1NumberSwapper {
    fun runTest() {
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