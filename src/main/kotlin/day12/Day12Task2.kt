package day12

import kotlin.math.abs

class Day12Task2 {
    fun task1(lines: List<String>): Int =
        calculateFinalPosition(lines).let {
            abs(it.x) + abs(it.y)
        }

    fun calculateFinalPosition(
        lines: List<String>,
    ) = lines.map {
        val actionS = it[0]
        val valueS = it.drop(1).toInt()
        when (actionS) {
            'N' -> MoveWaypoint.N(valueS)
            'S' -> MoveWaypoint.S(valueS)
            'W' -> MoveWaypoint.W(valueS)
            'E' -> MoveWaypoint.E(valueS)
            'L' -> RotateWaypoint(-valueS)
            'R' -> RotateWaypoint(valueS)
            'F' -> MoveTowardsWaypoint(valueS)
            else -> throw Exception()
        }
    }
        .fold(Position(0, 0, 10, 1)) { previousPosition, action ->
            action.execute(previousPosition)
        }

    sealed class Action(
        val execute: (position: Position) -> Position,
    )

    class MoveWaypoint(
        dx: Int,
        dy: Int,
        value: Int,
    ) : Action({ position ->
        position.copy(waypointX = position.waypointX + dx * value, waypointY = position.waypointY + dy * value)
    }) {
        companion object {
            fun N(valueS: Int) = MoveWaypoint(0, 1, valueS)
            fun S(valueS: Int) = MoveWaypoint(0, -1, valueS)
            fun W(valueS: Int) = MoveWaypoint(-1, 0, valueS)
            fun E(valueS: Int) = MoveWaypoint(1, 0, valueS)
        }
    }

    class RotateWaypoint(degrees: Int) : Action(
        { position ->
            when (degrees) {
                90, -270 -> position.copy(waypointX = position.waypointY, waypointY = -position.waypointX)
                180, -180 -> position.copy(waypointX = -position.waypointX, waypointY = -position.waypointY)
                270, -90 -> position.copy(waypointX = -position.waypointY, waypointY = position.waypointX)
                else -> throw Exception(degrees.toString())
            }
        }
    )

    class MoveTowardsWaypoint(value: Int) : Action({ position ->
        val dx = position.waypointX * value
        val dy = position.waypointY * value
        position.copy(x = position.x + dx, y = position.y + dy)
    })

    data class Position(
        val x: Int,
        val y: Int,
        val waypointX: Int,
        val waypointY: Int,
    )
}