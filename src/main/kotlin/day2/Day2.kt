package day2

class Day2 {
    fun task1(input: String): Int {
        return input.split("\n")
            .map {
                val (min, max, c, pass) = it.split("-", " ", ": ")
                (min.toInt()..max.toInt()).contains(pass.count { it == c.first() })
                    .let { if (it) 1 else 0 }
            }.sum()
    }
}