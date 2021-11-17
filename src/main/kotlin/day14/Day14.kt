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

    fun task2(input: String): Long {
        val memory = mutableMapOf<Long, Long>()
        var mask = ""
        input.lines()
            .forEach { line ->
                if (line.startsWith("mask = ")) {
                    mask = line.substringAfter("mask = ")
                } else {
                    val (addressString, decimalValueString) = Regex("[0-9]+")
                        .findAll(line)
                        .toList()

                    val addressInBitString = addressString.value.toInt().toString(2).padStart(36, '0')
                    val maskedAddressInBitString = mask.mapIndexed { index, maskChar ->
                        when (maskChar) {
                            '1', 'X' -> maskChar
                            '0' -> addressInBitString.getOrElse(index) { '0' }
                            else -> throw Exception()
                        }
                    }.joinToString("")
                    val floatingXMatchResults = "X".toRegex().findAll(mask).toList()
                    floatingXMatchResults.runningFold(listOf(maskedAddressInBitString)) { acc, result ->
                        acc.flatMap {
                            listOf(
                                it.replaceRange(result.range, "0"),
                                it.replaceRange(result.range, "1")
                            )
                        }
                    }
                        .last()
                        .forEach { memory[it.toLong(2)] = decimalValueString.value.toLong() }
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