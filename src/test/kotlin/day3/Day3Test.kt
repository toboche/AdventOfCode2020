package day3

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day3Test {

    @Test
    fun task1ExampleTest() {
        val input = File("src/test/resources/exampleDay3.txt")
            .readText()

        assertEquals(
            7,
            Day3().task1(input)
        )
    }

    @Test
    fun task2SolutionTest() {
        val input = File("src/test/resources/task1Day3.txt")
            .readText()

        assertEquals(
            250,
            Day3().task1(input)
        )
    }

}