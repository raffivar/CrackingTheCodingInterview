package chapter_8_recursion

import Solution
import java.lang.Integer.max

class S13StackOfBoxes : Solution {
    class Box(val w: Int, val h: Int, val d: Int)

    private fun canStack(b1: Box, b2: Box): Boolean {
        return b1.w > b2.w && b1.h > b2.h && b1.d > b2.d
    }

    private fun highestPossibleStack(boxes: ArrayList<Box>): Int {
        sortByHeight(boxes)
        return maxHeight(boxes)
    }

    private fun sortByHeight(boxes: ArrayList<Box>) {
        boxes.sortByDescending { box -> box.h }
    }

    private fun maxHeight(boxes: ArrayList<Box>): Int {
        val heights = arrayListOf<Int>()
        for (i in boxes.indices) {
            val subBoxes = ArrayList(boxes.slice(i..boxes.lastIndex))
            heights.add(maxHeightPerBox(subBoxes))
        }
        return heights.maxOrNull() ?: 0
    }

    private fun maxHeightPerBox(boxes: ArrayList<Box>): Int {
        if (boxes.isEmpty()) {
            return 0
        }
        val box = boxes[0]
        var height = box.h
        var i = 1
        while (i < boxes.size && !canStack(box, boxes[i])) {
            i++
        }
        val subBoxes = ArrayList(boxes.slice(i..boxes.lastIndex))
        height += maxHeightPerBox(subBoxes)
        return height
    }

    private fun createStack(boxes: ArrayList<Box>): Int {
        sortByHeight(boxes)
        val stackMap = IntArray(boxes.size)
        return createStack(boxes, null, 0, stackMap)
    }

    private fun createStack(boxes: ArrayList<Box>, bottom: Box?, offset: Int, stackMap: IntArray): Int {
        if (offset >= boxes.size) {
            return 0
        }
        val newBottom = boxes[offset]
        var heightWithBottom = 0
        if (bottom == null || canStack(bottom, newBottom)) {
            if (stackMap[offset] == 0) {
                stackMap[offset] = createStack(boxes, newBottom, offset + 1, stackMap)
                stackMap[offset] += newBottom.h
            }
            heightWithBottom = stackMap[offset]
        }
        val heightWithoutBottom = createStack(boxes, bottom, offset + 1, stackMap)
        return max(heightWithBottom, heightWithoutBottom)
    }

    override fun runTest() {
        val functions = arrayListOf(this::highestPossibleStack, this::createStack)
        val testCases = arrayListOf(
            arrayListOf(
                Box(1, 2, 3),
                Box(4, 5, 6),
                Box(6, 7, 8)
            ),
            arrayListOf(
                Box(5, 1, 5),
                Box(6, 2, 6),
                Box(7, 3, 7),
                Box(4, 4, 4)
            ),
        )
        for (function in functions) {
            println("------------------------------------")
            println("Using ${function.name}")
            for (testCase in testCases) {
                println("------------------------------------")
                printBoxes(testCase)
                println("Highest possible stack: ${highestPossibleStack(testCase)}")
            }
            println()
        }
    }

    private fun printBoxes(boxes: ArrayList<Box>) {
        for (box in boxes) {
            println("[${box.w}, ${box.h}, ${box.w}]")
        }
    }
}