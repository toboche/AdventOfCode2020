package day13

class Day13 {
    fun task1(input: String): Int {
        val (earliestString, ids) = input.lines()
        val earliest = earliestString.toInt()
        return ids.split(',')
            .filterNot { it == "x" }
            .map { it.toInt() }
            .map { it to earliest % it }
            .sortedByDescending { it.second }
            .first()
            .let {
                (it.first - it.second) * it.first
            }
    }

    fun task2(input: String): Long {
        val buses = input.lines()[1]
            .split(',')
            .mapIndexedNotNull { index, s -> if (s == "x") null else index to s.toInt() }

        var stepSize = buses.first().second
        var time = 0L
        buses.drop(1).forEach { (offset, bus) ->
            while ((time + offset) % bus != 0L) {
                time += stepSize
            }
            stepSize *= bus
        }
        return time
    }
}