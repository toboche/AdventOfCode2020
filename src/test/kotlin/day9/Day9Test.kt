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

    @Test
    fun example2Test() {
        val input = File("src/test/resources/exampleDay9.txt")

        assertEquals(
            62,
            Day9().task2(input, 5)
        )
    }

    @Test
    fun task2Test() {
        val input = File("src/test/resources/task1Day9.txt")

        assertEquals(
            59341885,
            Day9().task2(input, 25)
        )
    }

}