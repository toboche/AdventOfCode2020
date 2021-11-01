package day10

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals


class Day10Test {
    @Test
    fun example1Test() {
        val input = File("src/test/resources/exampleDay10.txt")
        assertEquals(
            35,
            Day10().task1(input)
        )
    }

    @Test
    fun example2Test() {
        val input = File("src/test/resources/example2Day10.txt")

        assertEquals(
            220,
            Day10().task1(input)
        )
    }

    @Test
    fun task1Test() {
        val input = File("src/test/resources/task1Day10.txt")

        assertEquals(
            1690,
            Day10().task1(input)
        )
    }
}