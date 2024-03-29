package chapter_8_recursion

import Solution
import kotlin.collections.ArrayList

class S7PermutationsNoDups : Solution {
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
                    val prefix = perm.substring(0, i)
                    val suffix = perm.substring(i)
                    println("$prefix + $firstChar + $suffix")
                    perms.add(prefix + firstChar + suffix)
                }
            }
        }
        return perms
    }

    override fun runTest() {
        val functions = arrayListOf(this::perms)
        val testCases = arrayListOf("NYX")
        for (function in functions) {
            for (case in testCases) {
                val perms = function(case)
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