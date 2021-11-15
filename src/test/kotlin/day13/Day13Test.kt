package day13

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day13Test {
    @Test
    fun example() {
        val input = "939\n" +
                "7,13,x,x,59,x,31,19"

        assertEquals(
            295,
            Day13().task1(input)
        )
    }

    @Test
    fun task1() {
        val input = "1002578\n" +
                "19,x,x,x,x,x,x,x,x,x,x,x,x,37,x,x,x,x,x,751,x,29,x,x,x,x,x,x,x,x,x,x,13,x,x,x,x,x,x,x,x,x,23,x,x,x,x,x,x,x,431,x,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,17"

        assertEquals(
            5257,
            Day13().task1(input)
        )
    }

    @Test
    fun exampleTask2() {
        val input = "939\n" +
                "7,13,x,x,59,x,31,19"

        assertEquals(
            1068781,
            Day13().task2(input)
        )
    }

    @Test
    fun task2() {
        val input = "1002578\n" +
                "19,x,x,x,x,x,x,x,x,x,x,x,x,37,x,x,x,x,x,751,x,29,x,x,x,x,x,x,x,x,x,x,13,x,x,x,x,x,x,x,x,x,23,x,x,x,x,x,x,x,431,x,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,17"

        assertEquals(
            5257,
            Day13().task2(input)
        )
    }
}