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

    fun task2(input: File, lookupParent: String): Int {
        val parentsToAllChildren = mutableMapOf<String, MutableList<Pair<String, Int>>>() //child bag, parentBags

        input.readLines()
            .forEach {
                val (parent, containedString) = it.split(" bags contain ")
                val children = containedString.split(" bags, ", " bags.", " bag, ", " bag.")
                    .filterNot { it == "" || it == "no other" }
                    .map { it.drop(2) to it[0].digitToInt() }
                if (parentsToAllChildren.contains(parent).not()) {
                    parentsToAllChildren[parent] = mutableListOf()
                }
                val parentToAllChildren = parentsToAllChildren[parent]!!
                parentToAllChildren.addAll(children)
            }

        return childrenCost(lookupParent, parentsToAllChildren) - 1
    }

    fun childrenCost(parent: String, parentsToAllChildren: MutableMap<String, MutableList<Pair<String, Int>>>): Int =
        parentsToAllChildren[parent]!!.sumOf {
            it.second * childrenCost(it.first, parentsToAllChildren)
        } + 1
}