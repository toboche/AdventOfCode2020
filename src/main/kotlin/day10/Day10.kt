package day10

import java.io.File

class Day10 {
    fun task1(input: File): Int {
        return input
            .readLines()
            .map { it.toInt() }
            .sorted()
            .let { listOf(0) + it + (it.last() + 3) }
            .windowed(2, 1)
            .groupBy { it[1] - it[0] }
            .let {
                it[1]!!.count() * it[3]!!.count()
            }
    }
}