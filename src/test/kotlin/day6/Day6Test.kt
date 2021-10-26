package day6

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day6Test {
    @Test
    fun example1Test() {
        val input = File("src/test/resources/exampleDay6.txt")

        assertEquals(
            11,
            Day6().task1(input)
        )
    }

    @Test
    fun task1Test() {
        val input = File("src/test/resources/task1Day6.txt")

        assertEquals(
            6534,
            Day6().task1(input)
        )
    }

    @Test
    fun example2Test() {
        val input = File("src/test/resources/exampleDay6.txt")

        assertEquals(
            6,
            Day6().task2(input)
        )
    }

    @Test
    fun task2Test() {
        val input = File("src/test/resources/task1Day6.txt")

        assertEquals(
            3402,
            Day6().task2(input)
        )
    }
}
