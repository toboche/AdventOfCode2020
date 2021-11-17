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

    @Test
    fun exampleTask2() {
        val input = "mask = 000000000000000000000000000000X1001X\n" +
                "mem[42] = 100\n" +
                "mask = 00000000000000000000000000000000X0XX\n" +
                "mem[26] = 1"

        assertEquals(
            208L,
            Day14().task2(input)
        )
    }

    @Test
    fun task2() {
        val input = File("src/test/resources/task1Day14.txt").readText()

        assertEquals(
            5272149590143L,
            Day14().task2(input)
        )
    }
}
