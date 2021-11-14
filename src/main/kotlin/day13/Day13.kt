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
}