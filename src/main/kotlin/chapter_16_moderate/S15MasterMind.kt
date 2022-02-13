package chapter_16_moderate

class S15MasterMind {
    private val n = 4
    private val colors = arrayOf('R', 'Y', 'G', 'B')

    private fun startGame() {
        val sb = StringBuilder()
        for (i in 1..n) {
            sb.append(colors.random())
        }
        val secret = sb.toString()
        println("secret: $secret")
        do {
            val guess = readln()
            when (isInputValid(guess)) {
                true -> println("input is valid")
                false -> println("input is invalid")
            }
        } while (!guess.equals(secret, true))
        print("You guessed the word!")
    }
    
    private fun isInputValid(input: String): Boolean {
        if (input.length != n) {
            return false
        }

        for (char in input) {
            if (!colors.contains(char.uppercaseChar())) {
                return false
            }
        }

        return true
    }

    fun runTest() {
        startGame()
    }
}