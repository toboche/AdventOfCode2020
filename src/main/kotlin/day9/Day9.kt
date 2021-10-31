package day9

import java.io.File

class Day9 {
    fun task1(input: File, preambleSize: Int): Long {
        val allNumbers = input.readLines()
            .map { it.toLong() }

        allNumbers.windowed(preambleSize + 1, 1, true)
            .forEach { window ->
                val analysed = window[preambleSize]
                val windowWithoutAnalysed = window.subList(0, preambleSize)
                val complements = windowWithoutAnalysed
                    .map { analysed - it }
                    .toSet()
                windowWithoutAnalysed.firstOrNull {
                    complements.contains(it)
                } ?: return analysed
            }
        throw Exception()
    }
}