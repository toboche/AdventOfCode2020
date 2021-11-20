package day16

import java.io.File

class Day16 {
    data class Rule(val name: String, val ranges: List<IntRange>)

    fun task1(input: File): Int {
        val readLines = input.readLines()
        val (rules, tickets, myTicket) = readAllData(readLines)
        val notMatchingValues = tickets.map { ticket ->
            ticket.filterNot { ticketValue ->
                rules.find { rule -> rule.ranges.find { range -> range.contains(ticketValue) } != null } != null
            }
        }
        return notMatchingValues.sumOf { it.sum() }
    }

    private fun readAllData(readLines: List<String>): Triple<List<Rule>, List<List<Int>>, List<Int>> {
        val rulesEnd = readLines.withIndex().find { it.value.isEmpty() }!!.index
        val myTicketEnd = readLines.withIndex().findLast { it.value.isEmpty() }!!.index
        val rules = readLines.subList(0, rulesEnd)
            .map {
                val (name, rangesString) = it.split(":")
                val ranges = rangesString.split(" or ")
                    .map {
                        val (min, max) = it.split("-")
                            .map { it.trim().toInt() }
                        IntRange(min, max)
                    }
                Rule(name, ranges)
            }
        val myTicket = readLines.subList(rulesEnd + 2, myTicketEnd)
            .first()
            .split(",")
            .map { it.toInt() }
        val tickets = readLines.subList(myTicketEnd + 2, readLines.size)
            .map {
                it.split(",")
                    .map { it.toInt() }
            }
        return Triple(rules, tickets, myTicket)
    }
}