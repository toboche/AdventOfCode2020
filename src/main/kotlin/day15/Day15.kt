package day15

class Day15 {
    data class LastTwoOccurrences(
        val veryLastOccurrence: Int,
        val previousOccurrence: Int?,
    )

    fun task1(input: String, limit: Int = 2020): Int {
        val init = input.split(",")
            .map { it.toInt() }
        var last: Int = -1
        val previousOccurrences = init.withIndex()
            .map {
                it.value to LastTwoOccurrences(it.index, null)
            }
            .toMap()
            .toMutableMap()

        (previousOccurrences.count() until limit)
            .forEach { iteration ->
                if (previousOccurrences.contains(last) && previousOccurrences[last]!!.previousOccurrence != null) {
                    last =
                        previousOccurrences[last]!!.veryLastOccurrence - previousOccurrences[last]!!.previousOccurrence!!
                    if (previousOccurrences.contains(last)) {
                        previousOccurrences[last] = previousOccurrences[last]!!.let {
                            it.copy(veryLastOccurrence = iteration,
                                previousOccurrence = it.veryLastOccurrence)
                        }
                    } else {
                        previousOccurrences[last] = LastTwoOccurrences(iteration, null)
                    }
                } else {
                    last = 0
                    previousOccurrences[0] = previousOccurrences[0]?.let {
                        it.copy(veryLastOccurrence = iteration, previousOccurrence = it.veryLastOccurrence)
                    } ?: LastTwoOccurrences(iteration, null)
                }
            }
        return last
    }
}