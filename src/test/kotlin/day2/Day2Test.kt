package day2

import java.io.File
import kotlin.test.assertEquals


class Day2Test {
    @org.junit.jupiter.api.Test
    fun sample1Test() {
        val input = "1-3 a: abcde\n" +
                "1-3 b: cdefg\n" +
                "1-3 b: b\n" +
                "1-3 b: aba\n" +
                "1-3 b: abababa\n" +
                "1-3 b: bbb\n" +
                "2-9 c: ccccccccc"
        assertEquals(
            6,
            Day2().task1(input)
        )
    }

    @org.junit.jupiter.api.Test
    fun task1Test() {
        val input = File("src/test/resources/exampleDay2.txt")
            .readText()

        assertEquals(
            607,
            Day2().task1(input)
        )
    }

    @org.junit.jupiter.api.Test
    fun sample2Test() {
        val input = "1-3 a: abcde\n" +
                "1-3 b: cdefg\n" +
                "2-9 c: ccccccccc"
        assertEquals(
            1,
            Day2().task2(input)
        )
    }

    @org.junit.jupiter.api.Test
    fun task2Test() {
        val input = File("src/test/resources/exampleDay2.txt")
            .readText()

        assertEquals(
            321,
            Day2().task2(input)
        )
    }
}