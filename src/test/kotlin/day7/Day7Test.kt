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
    fun taskTest() {
        val input = File("src/test/resources/task1Day7.txt")

        assertEquals(
            177,
            Day7().task1(input)
        )
    }

}