package day17

import java.lang.Integer.max

class Day17 {
    fun task1(input: List<String>, cycles: Int = 6): Long {
        val xWidth = max(input.first().length + 2 * (cycles - 1), input.first().length)
        val yWidth = max(input.size + 2 * (cycles - 1), input.size)
        val zWidth = cycles * 2 + 1

        val state = Array(xWidth) { Array(yWidth) { CharArray(zWidth) { '.' } } }

        val initialLayerZ = zWidth / 2 + 1
        val xOffset = (xWidth / 2 + 1) + input.first().length / 2
        val yOffset = (yWidth / 2 + 1) + input.size / 2

        input.forEachIndexed { lineIndex, line ->
            line.forEachIndexed { charIndex, char ->
                state[lineIndex + xOffset][charIndex + yOffset][initialLayerZ] = char
            }
        }

        return state.sumOf { it.sumOf { it.sumOf { if (it == '#') 1L else 0L } } }
    }
}