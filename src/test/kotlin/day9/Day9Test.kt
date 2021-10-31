package day9

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day9Test {
    @Test
    fun example1Test() {
        val input = File("src/test/resources/exampleDay9.txt")

        assertEquals(
            127,
            Day9().task1(input, 5)
        )
    }

    @Test
    fun task1Test() {
        val input = File("src/test/resources/task1Day9.txt")

        assertEquals(
            393911906,
            Day9().task1(input, 25)
        )
    }
}