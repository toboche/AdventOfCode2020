package day12

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day12Test {
    @Test
    fun example1Test() {
        val input = File("src/test/resources/exampleDay12.txt")
        assertEquals(
            25,
            Day12().task1(input)
        )
    }

    @Test
    fun task1Test() {
        val input = File("src/test/resources/task1Day12.txt")
        assertEquals(
            25,
            Day12().task1(input)
        )
    }
}