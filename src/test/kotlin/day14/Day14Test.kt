package day14

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day14Test {
    @Test
    fun example() {
        val input = "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X\n" +
                "mem[8] = 11\n" +
                "mem[7] = 101\n" +
                "mem[8] = 0"

        assertEquals(
            165L,
            Day14().task1(input)
        )
    }

    @Test
    fun task1() {
        val input = File("src/test/resources/task1Day14.txt").readText()

        assertEquals(
            165L,
            Day14().task1(input)
        )
    }

}