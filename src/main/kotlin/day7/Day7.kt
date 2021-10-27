package day7

import java.io.File

class Day7 {


    fun task1(input: File): Int {
        val childrenBagToAllParents = mutableMapOf<String, MutableList<String>>() //child bag, parentBags
        input.readLines()
            .forEach {
                val (parent, containedString) = it.split(" bags contain ")
                val contains = containedString.split(" bags, ", " bags.", " bag, ", " bag.")
                    .filterNot { it == "" || it == "no other" }
                    .map { it.drop(2) }
                contains.forEach { child ->
                    if (childrenBagToAllParents.contains(child).not()) {
                        childrenBagToAllParents[child] = mutableListOf()
                    }
                    val childTtoAllParents = childrenBagToAllParents[child]!!
                    childTtoAllParents.add(parent)
                }
            }
        val toVisit = mutableListOf<String>()
        val visited = mutableSetOf<String>()
        toVisit.addAll(childrenBagToAllParents["shiny gold"]!!)
        while (toVisit.isNotEmpty()) {
            val current = toVisit.removeFirst()
            visited.add(current)
            toVisit.addAll(
                childrenBagToAllParents[current]?.filterNot { visited.contains(it) } ?: emptyList()
            )
        }
        return visited.size
    }
}