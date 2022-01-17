package chapter_7_oop_design

import kotlin.collections.ArrayList

class S1DeckOfCards {
    enum class Suit { Heart, Diamond, Spade, Club }
    class Card(val value: Int, val suit: Suit)

    open class GenericDeck {
        private val deck = ArrayList<Card>()

        init {
            for (suit in Suit.values()) {
                for (num in 1..13) {
                    deck.add(Card(num, suit))
                }
            }
        }

        fun drawCard(): Card {
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

    private fun startBlackJackGame() {
        val deck = GenericDeck()
        while (deck.isNotEmpty()) {
            val card = deck.drawCard()
            println("Drew ${card.value} of ${card.suit}s")
        }
    }

    fun runTest() {
        startBlackJackGame()
    }
}