package day8

class Day8 {
    data class State(val acc: Int, val instruction: Int)
    sealed class Operation(val value: Int, val action: (State) -> (State))
    class Acc(value: Int) :
        Operation(value, {
            it.copy(
                acc = it.acc + value,
                instruction = it.instruction + 1
            )
        })

    class Jmp(val nextInstruction: Int) : Operation(nextInstruction, {
        it.copy(instruction = it.instruction + nextInstruction)
    })

    class NoOp(value: Int) : Operation(value, {
        it.copy(instruction = it.instruction + 1)
    })

    object End : Operation(0, { it })

    fun task1(input: List<String>): Int {
        val instructions = parseOperations(input)

        val finalStateOrInfinite = findFinalStateOfInfinite(instructions)
        return finalStateOrInfinite.first.acc
    }

    fun task2(input: List<String>): Int {
        val instructions = parseOperations(input)

        val jmpsAndNoopsIndices = instructions.withIndex().filter { operation ->
            operation.value is NoOp || operation.value is Jmp
        }
        jmpsAndNoopsIndices.forEach { opToChange ->
            val modifiedInstructions = swapOperationsForSingleIndex(instructions, opToChange)
            val finalStateOrInfinite = findFinalStateOfInfinite(modifiedInstructions)
            if (finalStateOrInfinite.second is End) {
                return finalStateOrInfinite.first.acc
            }
        }
        throw Exception()
    }

    private fun findFinalStateOfInfinite(instructions: List<Operation>): Pair<State, Operation?> {
        var state = State(0, 0)
        val executed = BooleanArray(instructions.size)
        while (state.instruction in instructions.indices && !executed[state.instruction]) {
            executed[state.instruction] = true
            val operation = instructions[state.instruction]
            if (operation == End) {
                break
            }
            state = operation.action(state)
        }
        return state to instructions.getOrNull(state.instruction)
    }

    private fun swapOperationsForSingleIndex(
        instructions: List<Operation>,
        opToChange: IndexedValue<Operation>,
    ) =
        instructions.mapIndexed { index, op ->
            if (opToChange.index == index) {
                if (op is Jmp) {
                    NoOp(op.value)
                } else {
                    Jmp(op.value)
                }
            } else {
                op
            }
        }


    private fun parseOperations(input: List<String>) = input
        .map {
            val (name, value) = it.split(" ")
            when (name) {
                "nop" -> NoOp(value.toInt())
                "acc" -> Acc(value.toInt())
                "jmp" -> Jmp(value.toInt())
                else -> throw Exception()
            }
        } + End
}