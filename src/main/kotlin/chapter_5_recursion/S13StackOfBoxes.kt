package chapter_5_recursion

class S13StackOfBoxes {
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
        println("height so far: $height")
        return height
    }


    private fun canStack(b1: Box, b2: Box): Boolean {
        return b1.w > b2.w && b1.h > b2.h && b1.d > b2.d
    }

    class Box(val w: Int, val h: Int, val d: Int)

    fun runTest() {
        val functions = arrayListOf(this::highestPossibleStack)
        val testCases = arrayListOf(
            arrayListOf(Box(1, 2, 3), Box(4, 5, 6), Box(6, 7, 8))
        )
        for (function in functions) {
            for (testCase in testCases) {
                println(highestPossibleStack(testCase))
            }
        }
    }
}