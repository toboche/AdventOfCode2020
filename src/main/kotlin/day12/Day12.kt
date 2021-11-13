package day12

import java.io.File
import kotlin.math.abs

sealed class Action(
    val execute: (position: Position) -> Position,
)

class Compass(
    dx: Int,
    dy: Int,
    value: Int,
) : Action({ position ->
    position.copy(x = position.x + dx * value, y = position.y + dy * value)
}) {
    companion object {
        fun N(valueS: Int) = Compass(0, 1, valueS)
        fun S(valueS: Int) = Compass(0, -1, valueS)
        fun W(valueS: Int) = Compass(-1, 0, valueS)
        fun E(valueS: Int) = Compass(1, 0, valueS)
    }
}

class Rotation(degrees: Int) : Action({ position -> position.copy(dir = position.dir + degrees) })

class ForwardMovement(value: Int) : Action({ position ->
    when (position.dir % 360) {
        90, -270 -> Compass.E(value)
        180, -180 -> Compass.S(value)
        270, -90 -> Compass.W(value)
        0 -> Compass.N(value)
        else -> throw Exception(value.toString())
    }.execute(position)
})

data class Position(
    val x: Int,
    val y: Int,
    val dir: Int,
)

class Day12 {
    fun task1(input: File): Int = input.readLines()
        .map {
            val actionS = it[0]
            val valueS = it.drop(1).toInt()
            when (actionS) {
                'N' -> Compass.N(valueS)
                'S' -> Compass.S(valueS)
                'W' -> Compass.W(valueS)
                'E' -> Compass.E(valueS)
                'L' -> Rotation(-valueS)
                'R' -> Rotation(valueS)
                'F' -> ForwardMovement(valueS)
                else -> throw Exception()
            }
        }
        .fold(Position(0, 0, 90)) { previousPosition, action ->
            action.execute(previousPosition)
        }.let {
            abs(it.x) + abs(it.y)
        }
}