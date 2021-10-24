package day3

class Day3 {
    fun task1(input: String, rowStep: Int = 1, colStep: Int = 3): Long {
        val rows = input.lines()
        val columnsCount = rows.first().length
        return solve(rows, rowStep, colStep, columnsCount)
    }

    private fun solve(
        rows: List<String>,
        rowStep: Int,
        colStep: Int,
        columnsCount: Int
    ): Long {
        return rows.indices
            .filter { it % rowStep == 0 }
            .mapIndexed { index, it -> it to (index * colStep) % columnsCount }
            .sumOf { (row, col) ->
                if (rows[row][col] == '#')
                    1L
                else
                    0L
            }
    }

    fun task2(input: String): Long {
        val rows = input.lines()
        val columnsCount = rows.first().length
        val slopes = listOf(
            1 to 1,
            3 to 1,
            5 to 1,
            7 to 1,
            1 to 2
        )
        return slopes.map { (colStep, rowStep) ->
            solve(rows, rowStep, colStep, columnsCount)
        }.fold(1L) { acc, count -> acc * count }
    }

}