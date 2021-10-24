package day3

class Day3 {
    fun task1(input: String, rowStep: Int = 1, colStep: Int = 3): Long {
        val rows = input.lines()
        val columns = rows.first().length
        return rows.indices
            .filter { it % rowStep == 0 }
            .map { it to (it * colStep) % columns }.sumOf { (row, col) ->
                if (rows[row][col] == '#')
                    1L
                else
                    0L
            }
    }

}