package chapter_5_recursion

import kotlin.collections.ArrayList

class S7PermutationsNoDups {
    private fun perms(s: String): ArrayList<String> {
        val perms = arrayListOf<String>()
        if (s.length <= 1) {
            perms.add(s)
        } else {
            val firstChar = s[0]
            val restOfTheWord = s.substring(1)
            for (perm in perms(restOfTheWord)) {
                println("Now inserting [$firstChar] into [$perm]")
                for (i in 0..perm.length) {
                    val prefix = restOfTheWord.substring(0, i)
                    val suffix = restOfTheWord.substring(i)
                    println("$prefix + $firstChar + $suffix")
                    perms.add(prefix + firstChar + suffix)
                }
            }
        }
        return perms
    }

    fun runTest() {
        val functions = arrayListOf(this::perms)
        val testCases = arrayListOf("NYX")
        for (function in functions) {
            for (case in testCases) {
                val perms = perms(case)
                println("-----------------------------------")
                println("Permutations of \"$case\":")
                printPerms(perms)
            }
        }
    }

    private fun printPerms(perms: ArrayList<String>) {
        for (perm in perms) {
            println(perm)
        }
    }
}