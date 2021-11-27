package day17

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day17Test {

//    @Test
//    fun task1Example() {
//        val input = (".#.\n" +
//                "..#\n" +
//                "###")
//            .lines()
//
//        assertEquals(
//            112,
//            Day17().task1(input)
//        )
//    }

    @Test
    fun task1Example1Cycle() {
        val input = (".#.\n" +
                "..#\n" +
                "###")
            .lines()

        assertEquals(
            5,
            Day17().task1(input)
        )
    }

}