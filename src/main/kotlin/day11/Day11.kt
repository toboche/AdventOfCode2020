package day11

import java.io.File

sealed class Place
object Occupied : Place()
object Empty : Place()
object Floor : Place()


class Day11 {
    fun task1(input: File): Long {
        val spaces = mapToSpacesArrays(input)
        runUntilStable(spaces)
        return spaces.sumOf { it.sumOf { if (it == Occupied) 1L else 0 } }
    }

    private fun mapToSpacesArrays(input: File): Array<Array<Place>> {
        val spaces = input.readLines()
            .map {
                it.map {
                    when (it) {
                        'L' -> Empty
                        '.' -> Floor
                        else -> Occupied
                    }
                }
                    .toTypedArray()
            }
            .toTypedArray()
        return spaces
    }

    private fun runUntilStable(spaces: Array<Array<Place>>) {
        var stable = false
        var previousSpaces = deepCopy(spaces)
        while (!stable) {
            stable = true
            for (i in previousSpaces.indices) {
                for (j in previousSpaces[i].indices) {
                    val it = previousSpaces[i][j]
                    spaces[i][j] =
                        if (it == Occupied && countNeighbors(previousSpaces, i, j) >= 4) {
                            stable = false
                            Empty
                        } else if (it == Empty && countNeighbors(previousSpaces, i, j) == 0) {
                            stable = false
                            Occupied
                        } else {
                            it
                        }
                }
            }
            previousSpaces = deepCopy(spaces)
        }
    }

    private fun deepCopy(spaces: Array<Array<Place>>) = spaces.map { it.copyOf() }.toTypedArray()

    fun countNeighbors(spaces: Array<Array<Place>>, row: Int, col: Int) =
        (row - 1..row + 1).map { i ->
            (col - 1..col + 1).map { j ->
                spaces.getOrElse(i) { emptyArray() }
                    .getOrElse(j) { Floor }
                    .let {
                        if (i == row && j == col) {
                            0
                        } else if (it == Occupied) {
                            1
                        } else {
                            0
                        }
                    }
            }.sum()
        }.sum()

}