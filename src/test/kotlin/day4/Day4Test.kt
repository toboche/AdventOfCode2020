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
            Day4().task1(input)
        )
    }
}