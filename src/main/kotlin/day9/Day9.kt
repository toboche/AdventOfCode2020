package day9

import java.io.File

class Day9 {
    fun task1(input: File, preambleSize: Int): Long {
        val allNumbers = input.readLines()
            .map { it.toLong() }

        return findErroneousValue(allNumbers, preambleSize)
    }

    fun task2(input: File, preambleSize: Int): Long {
        val allNumbers = input.readLines()
            .map { it.toLong() }

        val erroneousValue = findErroneousValue(allNumbers, preambleSize)
        val erroneousIndex = allNumbers.indexOf(erroneousValue)
        var i = 0
        var j = 0
        val possibleNumbers = allNumbers.subList(0, erroneousIndex)
        while (j != possibleNumbers.size || i != j) {
            val subList = possibleNumbers.subList(i, j)
            val sum = subList.sum()
            if (erroneousValue == sum) {
                return subList.minOrNull()!! + subList.maxOrNull()!!
            } else if (sum > erroneousValue) {
                i++
            } else {
                j++
            }
        }
        throw Exception()
    }

    private fun findErroneousValue(allNumbers: List<Long>, preambleSize: Int): Long {
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