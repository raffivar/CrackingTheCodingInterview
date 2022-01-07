package chapter_3_stacks_and_queues

import java.util.*

class S2StackMin {
    class MyStack : Stack<Int>(){
        private var min: Int = Int.MIN_VALUE

        fun min(): Int {
            return min
        }

        override fun push(item: Int): Int{
            if (item < min) {
                min = item
            }
            return super.push(item)
        }
    }
}