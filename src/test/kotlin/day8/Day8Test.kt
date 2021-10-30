package day8

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day8Test {
    @Test
    fun example1Test() {
        val input = File("src/test/resources/exampleDay8.txt")
            .readLines()

        assertEquals(
            5,
            Day8().task1(input)
        )
    }

    @Test
    fun task1Test() {
        val input = File("src/test/resources/task1Day8.txt")
            .readLines()

        assertEquals(
            1501,
            Day8().task1(input)
        )
    }
}