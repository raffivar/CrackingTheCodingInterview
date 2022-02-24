package chapter_16_moderate

import Solution
import java.lang.StringBuilder

class S12XMLEncoding : Solution {
    private val mapping = hashMapOf(
        Pair("family", 1),
        Pair("person", 2),
        Pair("firstName", 3),
        Pair("lastName", 4),
        Pair("state", 5),
    )

    class Element(
        val tag: String,
        val attributes: List<Attribute>?,
        val children: List<Element>?,
        val value: String?,
    )

    class Attribute(
        val tag: String,
        val value: String?
    )

    private fun encodeToString(root: Element): String {
        val sb = StringBuilder()
        encode(root, sb)
        return sb.toString()
    }

    private fun encode(root: Element, sb: StringBuilder) {
        encode(mapping[root.tag].toString(), sb)
        root.attributes?.let {
            for (a in it) {
                encode(a, sb)
            }
        }
        encode("0", sb)
        when (!root.value.isNullOrBlank()) {
            true -> encode(root.value, sb)
            false -> {
                root.children?.let {
                    for (e in it) {
                        encode(e, sb)
                    }
                }
            }
        }
        encode("0", sb)
    }

    private fun encode(attr: Attribute, sb: StringBuilder) {
        encode(mapping[attr.tag].toString(), sb)
        encode(attr.value, sb)
    }

    private fun encode(v: String?, sb: StringBuilder) {
        sb.append(v)
        sb.append(" ")
    }


    override fun runTest() {
        val myXml = Element(
            "family",
            listOf(
                Attribute("lastName", "McDowel"),
                Attribute("state", "CA")
            ),
            listOf(
                Element(
                    "person",
                    listOf(Attribute("firstName", "Gayle")), null, "Some Message"
                )
            ),
            null
        )
        println(encodeToString(myXml))
    }
}