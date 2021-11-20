package day16

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day16Test {
    @Test
    fun task1Example() {
        val input = File("src/test/resources/exampleDay16.txt")

        assertEquals(
            71,
            Day16().task1(input)
        )
    }

    @Test
    fun task1() {
        val input = File("src/test/resources/task1Day16.txt")

        assertEquals(
            29019,
            Day16().task1(input)
        )
    }

}