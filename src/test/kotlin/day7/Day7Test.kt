package day7

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day7Test {
    @Test
    fun example1Test() {
        val input = File("src/test/resources/exampleDay7.txt")

        assertEquals(
            4,
            Day7().task1(input)
        )
    }

    @Test
    fun task1Test() {
        val input = File("src/test/resources/task1Day7.txt")

        assertEquals(
            177,
            Day7().task1(input)
        )
    }

    @Test
    fun example2Test() {
        val input = File("src/test/resources/exampleDay7.txt")

        assertEquals(
            0,
            Day7().task2(input, "faded blue")
        )
        assertEquals(
            0,
            Day7().task2(input, "dotted black")
        )
        assertEquals(
            11,
            Day7().task2(input, "vibrant plum")
        )
        assertEquals(
            7,
            Day7().task2(input, "dark olive")
        )
    }

    @Test
    fun task2Test() {
        val input = File("src/test/resources/task1Day7.txt")

        assertEquals(
            34988,
            Day7().task2(input, "shiny gold")
        )
    }

}