package day5

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day5Test {
    @Test
    fun task1ExampleRowTest() {
        assertEquals(
            44,
            Day5().row("FBFBBFF")
        )
    }

    @Test
    fun task1ExampleColTest() {
        assertEquals(
            5,
            Day5().col("RLR")
        )
    }

    @Test
    fun task1ExampleSeatTest() {
        assertEquals(
            357,
            Day5().seat("FBFBBFFRLR")
        )
    }

    @Test
    fun task1Test() {
        val input = File("src/test/resources/task1Day5.txt")
            .readLines()

        assertEquals(
            832,
            Day5().highest(input)
        )
    }
}