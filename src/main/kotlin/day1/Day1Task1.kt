package day1

class Day1Task1 {
    fun solve(a: List<Int>): Int {
        val sorted = a.sorted()
        val found = sorted.withIndex().firstOrNull { (index, i) ->
            if (index == sorted.size) {
                false
            } else {
                sorted.subList(index + 1, sorted.size).contains(2020 - i)
            }
        }?.value
        return if (found != null) {
            found * (2020 - found)
        } else {
            0
        }
    }
}