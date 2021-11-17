package day14

class Day14 {
    fun task1(input: String): Long {
        val memory = mutableMapOf<Long, Long>()
        var onesMask = 0L
        var zerosMask = 0L
        input.lines()
            .forEach { line ->
                if (line.startsWith("mask = ")) {
                    parseMasks(line)
                        .let {
                            onesMask = it.first
                            zerosMask = it.second
                        }
                } else {
                    val (addressString, decimalValueString) = Regex("[0-9]+")
                        .findAll(line)
                        .toList()
                    val address = addressString.value.toLong()
                    val decimalValue = decimalValueString.value.toLong()
                    memory[address] = (decimalValue and zerosMask) or onesMask
                }
            }


        return memory.values.sumOf { it }
    }

    private fun parseMasks(line: String): Pair<Long, Long> {
        val mask = line.substringAfter("mask = ")
        val onesMask =
            mask.map { if (it == 'X') '0' else it }
                .map { it }
                .joinToString("")
                .toLong(2)

        val zerosMask =
            mask.map { if (it == 'X') '1'.code else '0'.code }
                .map { it.toChar() }
                .joinToString("")
                .toLong(2)
        return onesMask to zerosMask
    }
}