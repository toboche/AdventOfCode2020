package day2

class Day2 {
    fun task1(input: String) = input.split("\n")
        .map {
            val (min, max, c, pass) = it.split("-", " ", ": ")
            (min.toInt()..max.toInt()).contains(pass.count { it == c.first() })
                .let { if (it) 1 else 0 }
        }.sum()

    fun task2(input: String) = input.split("\n")
        .map {
            val (firstS, secondS, cS, pass) = it.split("-", " ", ": ")
            val first = pass[firstS.toInt() - 1]
            val second = pass[secondS.toInt() - 1]
            val c = cS.first()
            if ((first == c) xor (second == c)) 1 else 0
        }.sum()
}