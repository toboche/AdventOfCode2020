package day12

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day12Task2Test {
    @Test
    fun forwardWorks() {
        assertEquals(
            Day12Task2.Position(100, 10, 90, 10, 1),
            Day12Task2().calculateFinalPosition(listOf("F10"))
        )
    }
}