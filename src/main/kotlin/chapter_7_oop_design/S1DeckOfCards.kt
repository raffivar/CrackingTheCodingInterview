package chapter_7_oop_design

import kotlin.collections.ArrayList

class S1DeckOfCards {
    enum class Shape { Heart, Diamond, Spade, Club }
    enum class Name { Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King }
    class Card(val shape: Shape, val name: Name, value: Int) {
        var value = value
            set(num) {
                when (num in 1..13) {
                    true -> field = num
                    false -> println("cannot assign negative or above 13")
                }
            }
    }

    open class GenericDeck {
        private val deck = ArrayList<Card>()

        init {
            for (shape in Shape.values()) {
                val names = Name.values()
                for (i in 0..names.lastIndex) {
                    deck.add(Card(shape, names[i], i + 1))
                }
            }
        }

        open fun drawCard(): Card {
            val card = deck.random()
            deck.remove(card)
            return card
        }

        fun isNotEmpty(): Boolean {
            return deck.isNotEmpty()
        }

        fun isEmpty(): Boolean {
            return deck.isEmpty()
        }
    }

    class BlackJackDeck : GenericDeck() {
        override fun drawCard(): Card {
            val card = super.drawCard()
            if (card.value > 10) {
                card.value = 10
            }
            return card
        }
    }

    private fun startBlackJackGame() {
        val deck = BlackJackDeck()
        var drewAce = false
        var sum = 0
        var score = 0
        while (score <= 21 && deck.isNotEmpty()) {
            println("Please choose:\n1. Draw one more\n2. Stop")
            when (readLine()?.toIntOrNull()) {
                1 -> {
                    val card = deck.drawCard()
                    println("Drew ${card.name} of ${card.shape}s [Value: ${card.value}]")
                    if (card.name == Name.Ace) {
                        println("Value will be modified for player's benefit at the end of the game.")
                        drewAce = true
                    }
                    sum += card.value
                    // Add 10 to ace if needed
                    // [We only refer to one of the aces drawn, since 11 + 11 is already 22]
                    score = when (drewAce && sum + 10 <= 21) {
                        true -> sum + 10
                        false -> sum
                    }
                    println("Score so far: $score.")
                }
                2 -> break
                else -> println("Invalid choice.")
            }
        }
        val finalScoreStr = "Final score: $score"
        when (score) {
            in 0..20 -> println("$finalScoreStr.")
            21 -> println("$finalScoreStr - BLACKJACK!")
            else -> println("$finalScoreStr - Unfortunate.")
        }
    }

    fun runTest() {
        startBlackJackGame()
    }
}