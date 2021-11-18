package day15

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day15Test {
    @Test
    fun exampleTask1() {
        val input = "0,3,6"

        assertEquals(
            436,
            Day15().task1(input)
        )
    }

    @Test
    fun example2Task1() {
        val input = "1,3,2"

        assertEquals(
            1,
            Day15().task1(input)
        )
    }

    @Test
    fun example3Task1() {
        val input = "2,1,3"

        assertEquals(
            10,
            Day15().task1(input)
        )
    }

    @Test
    fun exampleLastTask1() {
        val input = "3,1,2"

        assertEquals(
            1836,
            Day15().task1(input)
        )
    }

    @Test
    fun task1() {
        val input = "7,12,1,0,16,2"

        assertEquals(
            410,
            Day15().task1(input)
        )
    }

    @Test
    fun task2Example() {
        val input = "0,3,6"

        assertEquals(
            175594,
            Day15().task1(input, 30000000)
        )
    }

    @Test
    fun task2() {
        val input = "7,12,1,0,16,2"

        assertEquals(
            410,
            Day15().task1(input, 30000000)
        )
    }
}