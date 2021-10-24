package day4

class Day4 {

    companion object {
        val REQUIRED = listOf(
            "byr",
            "iyr",
            "eyr",
            "hgt",
            "hcl",
            "ecl",
            "pid"
        )
    }

    fun task1(input: String): Int {
        val acc = mutableListOf<MutableList<String>>()
        input.lines().fold(true) { previousLineWasBlank, line ->
            if (line.isBlank()) {
                return@fold true
            }
            if (previousLineWasBlank) {
                acc.add(mutableListOf())
            }
            acc.last().addAll(
                line.split(" ")
                    .map { it.substringBefore(":") }
            )
            false
        }
        return acc.count { it.containsAll(REQUIRED) }
    }

}