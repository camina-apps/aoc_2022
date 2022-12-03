import kotlin.math.floor
import kotlin.math.roundToInt

fun main() {

    fun priorityOfItem(letter: Char): Int {
        return if (letter.isUpperCase()) {
            letter.code - 38
        } else {
            letter.code - 96
        }
    }

    fun findDuplicate(rucksack: String): Char {
        val half = (rucksack.length / 2.0).roundToInt()
        val firstCompartment = rucksack.slice(0 until half).toList()
        val secondCompartment = rucksack.slice(half until rucksack.length).toList()
        val duplicate = firstCompartment.intersect(secondCompartment)
        return duplicate.first()
    }

    fun findDuplicateBetweenElves(elvesRucksacks: List<String>): Char {
        val firstRucksack = elvesRucksacks.first().map { it.toChar() }
        val secondRucksack = elvesRucksacks[1].map { it.toChar() }
        val thirdRucksack = elvesRucksacks.last().map { it.toChar() }
        val intersection = firstRucksack.intersect(secondRucksack)
        val secondIntersection = thirdRucksack.intersect(intersection)
        return secondIntersection.first()
    }

    fun part1(input: List<String>): Int {
        return input.map {
            val item = findDuplicate(it)
            priorityOfItem(item)
        }.sum()
    }

    fun part2(input: List<String>): Int {
        val groups = input.chunked(3)
        return groups.map {
            val badge = findDuplicateBetweenElves(it)
            priorityOfItem(badge)
        }.sum()
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
