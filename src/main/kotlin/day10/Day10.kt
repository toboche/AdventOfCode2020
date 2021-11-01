package day10

import java.io.File
import java.math.BigInteger

class Day10 {
    fun task1(input: File): Int {
        return parseInputAddingFirstAndLast(input)
            .windowed(2, 1)
            .groupBy { it[1] - it[0] }
            .let {
                it[1]!!.count() * it[3]!!.count()
            }
    }

    fun task2(input: File): Long {
        val pathsToAdapter = mutableMapOf(0 to 1L)
        val parsedInputAddingFirstAndLast = parseInputAddingFirstAndLast(input)
        parsedInputAddingFirstAndLast
            .drop(1)
            .forEach { currentAdapter ->
                pathsToAdapter[currentAdapter] = (1..3).sumOf { howMuchToGoBack ->
                    pathsToAdapter.getOrDefault(currentAdapter - howMuchToGoBack, 0L)
                }
            }

        return pathsToAdapter[parsedInputAddingFirstAndLast.last()]!!
    }

    fun task2SolutionThatFailsForLargeInput(input: File): BigInteger {
        val graph = parseInputAddingFirstAndLast(input)
            .windowed(4, 1, true)
            .associate { window ->
                val min = window[0]
                val rest = window.drop(1)
                    .filter { min + 3 >= it }
                min to rest
            }

        val destination = graph.keys.last() // no guarantee

        return dfs(0, destination, graph)
    }

    fun dfs(source: Int, destination: Int, graph: Map<Int, List<Int>>): BigInteger =
        if (source == destination) {
            1.toBigInteger()
        } else {
            graph[source]!!.sumOf {
                dfs(it, destination, graph)
            }
        }


    private fun parseInputAddingFirstAndLast(input: File) =
        input
            .readLines()
            .map { it.toInt() }
            .sorted()
            .let { listOf(0) + it + (it.last() + 3) }
}