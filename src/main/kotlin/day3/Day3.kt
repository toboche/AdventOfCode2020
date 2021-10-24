package day3

class Day3 {
    fun task1(input: String): Long {
        val rows = input.lines()
        val columns = rows.first().length
        return rows.indices
            .map { it to (it * 3) % columns }.sumOf { (row, col) ->
                if (rows[row][col] == '#')
                    1L
                else
                    0L
            }
    }

}