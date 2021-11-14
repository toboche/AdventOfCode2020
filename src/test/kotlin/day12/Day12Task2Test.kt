package day12

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day12Task2Test {
    @Test
    fun forward() {
        assertEquals(
            Day12Task2.Position(100, 10, 90, 10, 1),
            Day12Task2().calculateFinalPosition(listOf("F10"))
        )
    }

    @Test
    fun waypointMovement() {
        assertEquals(
            Day12Task2.Position(100, 10, 90, 10, 4),
            Day12Task2().calculateFinalPosition(listOf("F10",
                "N3"))
        )
    }

    @Test
    fun step3() {
        assertEquals(
            Day12Task2.Position(170, 38, 90, 10, 4),
            Day12Task2().calculateFinalPosition(listOf("F10",
                "N3",
                "F7"))
        )
    }

    @Test
    fun step4WithRotation() {
        assertEquals(
            Day12Task2.Position(170, 38, 90, 4, -10),
            Day12Task2().calculateFinalPosition(listOf("F10",
                "N3",
                "F7",
                "R90"))
        )
    }

    @Test
    fun step5() {
        assertEquals(
            Day12Task2.Position(214, -72, 90, 4, -10),
            Day12Task2().calculateFinalPosition(listOf("F10",
                "N3",
                "F7",
                "R90",
                "F11"))
        )
    }

    @Test
    fun example() {
        val input = File("src/test/resources/exampleDay12.txt")
            .readLines()

        assertEquals(
            286,
            Day12Task2().task1(input)
        )
    }
}