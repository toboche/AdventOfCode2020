package day1

class Day1 {
    fun solveTask1(a: List<Int>): Int {
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

    fun solveTask2(a: List<Int>): Int {
        val sorted = a.toSortedSet()
        val lastElement = sorted.last()
        for (i in 0 until sorted.size - 2) {
            for (j in i + 1 until sorted.size) {
                if (sorted.contains(2020 - sorted.elementAt(i) - sorted.elementAt(j))) {
                    return sorted.elementAt(i) * sorted.elementAt(j) * (2020 - sorted.elementAt(i) - sorted.elementAt(j))
                }
            }
        }
        return -1
    }
}