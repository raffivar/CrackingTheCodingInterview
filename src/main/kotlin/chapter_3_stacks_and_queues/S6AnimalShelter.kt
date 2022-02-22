package chapter_3_stacks_and_queues

import Solution
import java.lang.Exception

class S6AnimalShelter : Solution {
    /**
     * Another solution to this problem can be two lists (dogs + cats)
     * And for "Animal" to contain "timestamp"
     * This way, when performing dequeueAny(), if there are dogs **and** cats available,
     * we compare the timestamp and return the oldest
     */

    open class Animal(val name: String)
    class Cat(name: String) : Animal(name)
    class Dog(name: String) : Animal(name)
    class AnimalNode(
        val animal: Animal,
        var next: AnimalNode?
    )

    class AnimalShelter {
        private var head: AnimalNode? = null
        private var tail: AnimalNode? = null

        fun enqueue(animal: Animal) {
            println("Inserted: ${animal.name} [${animal.javaClass.simpleName}]")
            val newAnimalNode = AnimalNode(animal, null)
            if (tail == null) {
                head = newAnimalNode
                tail = newAnimalNode
            } else {
                tail!!.next = newAnimalNode
                tail = tail!!.next
            }
        }

        fun dequeueAny(): Animal {
            println("[Getting Any]")
            if (head == null) {
                throw Exception("Shelter empty exception")
            }
            val animal = head!!.animal
            head = head!!.next
            return animal
        }

        fun dequeueDog(): Dog {
            println("[Getting Dog]")
            return dequeueSpecific()
        }


        fun dequeueCat(): Cat {
            println("[Getting Cat]")
            return dequeueSpecific()
        }

        private inline fun <reified T> dequeueSpecific(): T {
            var p = head
            while (p?.next != null && p.animal !is T && p.next!!.animal !is T) {
                p = p.next
            }

            if (p == null) {
                throw Exception("No ${T::class.simpleName} found")
            }

            //first node is T
            if (p.animal is T) {
                val animal = p.animal
                head = head!!.next
                return animal as T
            }

            if (p.next == null) {
                throw Exception("No ${T::class.simpleName} found")
            }

            //next must be T
            val animal = p.next!!.animal
            p.next = p.next!!.next
            return animal as T
        }

        fun printCurrentState() {
            var p = head
            while (p != null) {
                print("${p.animal.name} [${p.animal.javaClass.simpleName}] -> ")
                p = p.next
            }
            println("||")
        }
    }

    override fun runTest() {
        val shelter = AnimalShelter()
        shelter.enqueue(Dog("Max"))
        shelter.enqueue(Cat("Babe"))
        shelter.enqueue(Dog("Dog1"))
        shelter.enqueue(Dog("Dog2"))
        shelter.enqueue(Cat("Sheesh"))
        shelter.printCurrentState()
        printOutput(shelter.dequeueCat())
        shelter.enqueue(Cat("Woop"))
        shelter.printCurrentState()
        printOutput(shelter.dequeueDog())
        shelter.printCurrentState()
        printOutput(shelter.dequeueAny())
        shelter.printCurrentState()
        printOutput(shelter.dequeueAny())
        shelter.printCurrentState()
        printOutput(shelter.dequeueAny())
        shelter.printCurrentState()
        printOutput(shelter.dequeueAny())
        shelter.printCurrentState()
    }

    private fun printOutput(animal: Animal) {
        println("Got animal: ${animal.name} [${animal.javaClass.simpleName}]")
    }
}