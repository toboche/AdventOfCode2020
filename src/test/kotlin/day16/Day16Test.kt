package day16

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day16Test {
    @Test
    fun task2Example() {
        val input = File("src/test/resources/exampleDay16.txt")

        assertEquals(
            71,
            Day16().task1(input)
        )
    }

}