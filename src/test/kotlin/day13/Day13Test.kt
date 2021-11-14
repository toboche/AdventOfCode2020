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
}