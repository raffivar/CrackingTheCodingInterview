package chapter_3_stacks_and_queues

import java.lang.Exception

class S6AnimalShelter {
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
            if (head == null) {
                throw Exception("Shelter empty exception")
            }

            val animal = head!!.animal
            head = head!!.next
            return animal
        }

        fun dequeueDog(): Dog {
            var p = head
            while (p?.next != null && p.animal !is Dog && p.next!!.animal !is Dog) {
                p = p.next
            }

            if (p == null) {
                throw Exception("No dog found")
            }

            //First node is dog
            if (p.animal is Dog) {
                val animal = p.animal
                head = head!!.next
                return animal as Dog
            }

            if (p.next == null) {
                throw Exception("No dog found")
            }

            //next must be Dog
            val animal = p.next!!.animal
            p.next = p.next!!.next
            return animal as Dog
        }


        fun dequeueCat(): Cat {
            var p = head
            while (p?.next != null && p.animal !is Cat && p.next!!.animal !is Cat) {
                p = p.next
            }

            if (p == null) {
                throw Exception("No cat found")
            }

            //First node is cat
            if (p.animal is Cat) {
                val animal = p.animal
                head = head!!.next
                return animal as Cat
            }

            if (p.next == null) {
                throw Exception("No cat found")
            }

            //next must be cat
            val animal = p.next!!.animal
            p.next = p.next!!.next
            return animal as Cat
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

    fun runTest() {
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
    }

    private fun printOutput(animal: Animal) {
        println("Got animal: ${animal.name} [${animal.javaClass.simpleName}]")
    }
}