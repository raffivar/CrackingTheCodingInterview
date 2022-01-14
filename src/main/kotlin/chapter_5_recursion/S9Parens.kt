package chapter_5_recursion

import java.lang.StringBuilder
import java.util.*

class S9Parens {
    private fun parens(num: Int): Set<String> {
        val sb = StringBuilder()
        for (i in 1..num) {
            sb.append("()")
        }
        val parens = sb.toString()
        return perms(parens, parens.length)
    }

    private fun perms(s: String, originalLength: Int): Set<String> {
        val perms = mutableSetOf<String>()
        if (s.length <= 1) {
            addParens(s, originalLength, perms)
        } else {
            val firstChar = s[0]
            val restOfTheWord = s.substring(1)
            for (perm in perms(restOfTheWord, originalLength)) {
                println("Now inserting [$firstChar] into [$perm]")
                for (i in 0..perm.length) {
                    val prefix = perm.substring(0, i)
                    val suffix = perm.substring(i)
                    println("$prefix + $firstChar + $suffix")
                    val current = prefix + firstChar + suffix
                    addParens(current, originalLength, perms)
                }
            }
        }
        return perms
    }

    private fun addParens(s: String, originalLength: Int, perms: MutableSet<String>) {
        if (s.length < originalLength || validParens(s)) {
            perms.add(s)
        }
    }

    private fun validParens(s: String): Boolean {
        val stack = Stack<Char>()
        for (c in s) {
            when (c) {
                '(' -> stack.push(c)
                ')' -> {
                    when (stack.isEmpty()) {
                        true -> return false
                        false -> stack.pop()
                    }
                }
                else -> return false
            }
        }
        return stack.isEmpty()
    }

    fun runTest() {
        val functions = arrayListOf(this::parens)
        val testCases = arrayListOf(3)
        for (function in functions) {
            for (case in testCases) {
                val perms = parens(case)
                println("-----------------------------------")
                println("Permutations of $case:")
                printPerms(perms)
            }
        }
    }

    private fun printPerms(perms: Set<String>) {
        for (perm in perms) {
            println(perm)
        }
    }
}