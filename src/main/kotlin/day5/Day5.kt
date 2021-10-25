package day5

class Day5 {
    fun row(row: String) = Integer.parseInt(row.toList().map { if (it == 'F') '0' else '1' }
        .joinToString(""), 2)

    fun col(row: String) = Integer.parseInt(row.toList().map { if (it == 'R') '1' else '0' }
        .joinToString(""), 2)

    fun seat(seatEncoded: String) =
        row(seatEncoded.take(7)) * 8 + col(seatEncoded.takeLast(3))

    fun highest(seatsEncoded: List<String>) =
        seatsEncoded.maxOf { seat(it) }

    fun mySeat(seatsEncoded: List<String>) =
        seatsEncoded.map { seat(it) }.sorted().windowed(2, 1).first { it[1] - it[0] > 1 }[0] + 1
}