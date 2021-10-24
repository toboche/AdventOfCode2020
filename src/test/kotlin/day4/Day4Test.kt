package day4

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day4Test {
    @Test
    fun task1ExampleTest() {
        val input = File("src/test/resources/exampleDay4.txt")
            .readText()

        assertEquals(
            2,
            Day4().task(input)
        )
    }

    @Test
    fun task1Test() {
        val input = File("src/test/resources/task1Day4.txt")
            .readText()

        assertEquals(
            235,
            Day4().task(input)
        )
    }

    @Test
    fun task2ExampleTest() {
        val input = File("src/test/resources/exampleTask2Day4.txt")
            .readText()

        assertEquals(
            4,
            Day4().task(input, true)
        )
    }

    @Test
    fun task2Test() {
        val input = File("src/test/resources/task1Day4.txt")
            .readText()

        assertEquals(
            194,
            Day4().task(input, true)
        )
    }
}