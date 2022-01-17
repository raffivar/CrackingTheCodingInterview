package chapter_7_oop_design

import kotlin.collections.ArrayList

class S1DeckOfCards {
    enum class Shape { Heart, Diamond, Spade, Club }
    enum class Name { Ace, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King }
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
                for (num in 1..names.lastIndex) {
                    val name = names[num]
                    deck.add(Card(shape, name, num + 1))
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
        while (deck.isNotEmpty()) {
            val card = deck.drawCard()
            println("Drew ${card.name} of ${card.shape}s [Value: ${card.value}]")
        }
    }

    fun runTest() {
        startBlackJackGame()
    }
}