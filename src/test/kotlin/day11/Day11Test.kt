package day11

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day11Test {
    @Test
    fun example1Test() {
        val input = File("src/test/resources/exampleDay11.txt")
        assertEquals(
            37,
            Day11().task1(input)
        )
    }

    @Test
    fun task1Test() {
        val input = File("src/test/resources/task1Day11.txt")
        assertEquals(
            2261,
            Day11().task1(input)
        )
    }

    @Test
    fun example2Test() {
        val input = File("src/test/resources/exampleDay11.txt")
        assertEquals(
            26,
            Day11().task2(input)
        )
    }

    @Test
    fun task2Test() {
        val input = File("src/test/resources/task1Day11.txt")
        assertEquals(
            2039,
            Day11().task2(input)
        )
    }
}