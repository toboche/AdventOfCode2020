package day6

import java.io.File

class Day6 {
    private val aCode = 'a'.code

    fun task1(input: File): Int {
        val groups = input.readText()
            .split("\n\n")
            .map {
                it
                    .split("", "\n")
                    .filterNot { it == "" || it == "\n" }
                    .map { it[0] }
            }

        return groups.map {
            val answers = BooleanArray(26)
            it.forEach {
                answers[it.code - aCode] = true
            }
            answers
        }
            .sumOf {
                it.count { it }
            }
    }

}