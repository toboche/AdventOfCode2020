package day11

import java.io.File

sealed class Place
object Occupied : Place()
object Empty : Place()
object Floor : Place()


class Day11 {
    fun task1(input: File): Long {
        val spaces = mapToSpacesArrays(input)
        runUntilStable(spaces, { places, i, j -> countAdjacentOccupied(places, i, j) }, 4)
        return spaces.sumOf { it.sumOf { if (it == Occupied) 1L else 0 } }
    }

    fun task2(input: File): Long {
        val spaces = mapToSpacesArrays(input)
        runUntilStable(spaces, { places, i, j -> countVisibleOccupied(places, i, j) }, 5)
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

    private fun runUntilStable(
        spaces: Array<Array<Place>>, countOccupied: (Array<Array<Place>>, Int, Int) -> Long, toBecomeEmpty: Int,
    ) {
        var stable = false
        var previousSpaces = deepCopy(spaces)
        while (!stable) {
            stable = true
            for (i in previousSpaces.indices) {
                for (j in previousSpaces[i].indices) {
                    val it = previousSpaces[i][j]
                    spaces[i][j] =
                        if (it == Occupied && countOccupied(previousSpaces, i, j) >= toBecomeEmpty) {
                            stable = false
                            Empty
                        } else if (it == Empty && countOccupied(previousSpaces, i, j) == 0L) {
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

    fun countAdjacentOccupied(spaces: Array<Array<Place>>, row: Int, col: Int) =
        (row - 1..row + 1).sumOf { i ->
            (col - 1..col + 1).sumOf { j ->
                spaces.getOrElse(i) { emptyArray() }
                    .getOrElse(j) { Floor }
                    .let {
                        if (i == row && j == col) {
                            0L
                        } else if (it == Occupied) {
                            1
                        } else {
                            0
                        }
                    }
            }
        }

    val directions =
        arrayListOf(
            -1 to -1,
            -1 to 0,
            -1 to 1,
            0 to -1,
            0 to 1,
            1 to -1,
            1 to 0,
            1 to 1
        )

    private fun countVisibleOccupied(spaces: Array<Array<Place>>, row: Int, col: Int) =
        directions.sumOf { direction ->
            var current: Place = Floor
            var currentRow = row + direction.first
            var currentCol = col + direction.second
            while (current == Floor) {
                current = spaces.getOrElse(currentRow) { emptyArray() }
                    .getOrElse(currentCol) { Empty }
                currentRow += direction.first
                currentCol += direction.second
            }
            if (current == Occupied) {
                1L
            } else {
                0
            }
        }


}