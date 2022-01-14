package chapter_5_recursion

class S8PermutationsDups {
    private fun perms(s: String): Set<String> {
        val perms = mutableSetOf<String>()
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

    fun runTest() {
        val functions = arrayListOf(this::perms)
        val testCases = arrayListOf("XNYX")
        for (function in functions) {
            for (case in testCases) {
                val perms = function(case)
                println("-----------------------------------")
                println("Permutations of \"$case\":")
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