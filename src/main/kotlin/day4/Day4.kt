package day4

class Day4 {

    companion object {
        private val COLORS = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
        private val REQUIRED = mapOf<String, (String) -> Boolean>(
            "byr" to { it.length == 4 && it.toIntOrNull() in (1920 until 2003) },
            "iyr" to { it.length == 4 && it.toIntOrNull() in (2010 until 2021) },
            "eyr" to { it.length == 4 && it.toIntOrNull() in (2020 until 2031) },
            "hgt" to {
                (it.length == 5 && it.takeLast(2) == "cm" && it.take(3).toIntOrNull() in (150 until 194))
                        || (it.length == 4 && it.takeLast(2) == "in" && it.take(2).toIntOrNull() in (59 until 77))
            },
            "hcl" to { """#[0-9a-f]{6}""".toRegex().matches(it) },
            "ecl" to { COLORS.contains(it) },
            "pid" to { """[0-9]{9}""".toRegex().matches(it) }
        )
        private val REQUIRED_KEYS = REQUIRED.keys
    }

    fun task(input: String, applyValidation: Boolean = false): Int {
        val acc = groupEachPassportInSingleList(input)
        return if (applyValidation) {
            acc.count {
                it.count { (key, value) ->
                    REQUIRED[key]?.invoke(value) ?: false
                } == REQUIRED.size
            }
        } else {
            acc.count { it.map { it.first }.containsAll(REQUIRED_KEYS) }
        }
    }

    private fun groupEachPassportInSingleList(input: String): MutableList<MutableList<Pair<String, String>>> {
        val acc = mutableListOf<MutableList<Pair<String, String>>>()
        input.lines().fold(true) { previousLineWasBlank, line ->
            if (line.isBlank()) {
                return@fold true
            }
            if (previousLineWasBlank) {
                acc.add(mutableListOf())
            }
            acc.last().addAll(
                line.split(" ")
                    .map { it.substringBefore(":") to it.substringAfter(":") }
            )
            false
        }
        return acc
    }

}