package day8

class Day8 {
    data class State(val acc: Int, val instruction: Int)
    sealed class Operation(val action: (State) -> (State))
    class Acc(value: Int) :
        Operation({
            it.copy(
                acc = it.acc + value,
                instruction = it.instruction + 1
            )
        })

    class Jmp(nextInstruction: Int) : Operation({
        it.copy(instruction = it.instruction + nextInstruction)
    })

    object NoOp : Operation({
        it.copy(instruction = it.instruction + 1)
    })

    fun task1(input: List<String>): Int {
        val instructions = parseOperations(input)
        val executed = BooleanArray(instructions.size)

        var state = State(0, 0)

        while (!executed[state.instruction]) {
            executed[state.instruction] = true
            state = instructions[state.instruction].action(state)
        }
        return state.acc
    }

    private fun parseOperations(input: List<String>) = input
        .map {
            val (name, value) = it.split(" ")
            when (name) {
                "nop" -> NoOp
                "acc" -> Acc(value.toInt())
                "jmp" -> Jmp(value.toInt())
                else -> throw Exception()
            }
        }
}