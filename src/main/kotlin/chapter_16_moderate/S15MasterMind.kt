package chapter_16_moderate

class S15MasterMind {
    private val n = 4
    private val colors = arrayOf('R', 'Y', 'G', 'B')

    private enum class HitValue { Miss, PseudoHit, Hit }

    private fun startGame() {
        val sb = StringBuilder()
        for (i in 1..n) {
            sb.append(colors.random())
        }
        //val secret = sb.toString()
        val secret = "GBGG"
        println("secret: $secret")
        do {
            println("Enter your guess:")
            val guess = readln()
            when (isInputValid(guess)) {
                true -> {
                    val hits = calculateHits(secret, guess)
                    for (hit in hits) {
                        print("[$hit]")
                    }
                    println()
                }
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

    private fun calculateHits(secret: String, guess: String): Array<HitValue> {
        //Init all to be miss
        val result = Array(secret.length) { HitValue.Miss }
        val secretMap = HashMap<Int, Char>()

        //Take care of hits
        for ((i, char) in secret.withIndex()) {
            when (secret[i] == guess[i]) {
                true -> result[i] = HitValue.Hit
                false -> secretMap[i] = char
            }
        }

        //Take care of pseudo hits
        for (i in 0..guess.lastIndex) {
            if (result[i] != HitValue.Hit) {
                for (key in secretMap.keys) {
                    if (guess[i] == secretMap[key]) {
                        result[i] = HitValue.PseudoHit
                        secretMap.remove(key)
                        break
                    }
                }
            }
        }

        return result
    }

    fun runTest() {
        startGame()
    }
}