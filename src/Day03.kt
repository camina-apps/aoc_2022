import kotlin.math.floor
import kotlin.math.roundToInt

fun main() {

    fun priorityOfItem(letter: Char): Int {
        val offset = if (letter.isUpperCase()) 38 else 96
        return letter.code - offset
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
        return input.sumOf {
            val item = findDuplicate(it)
            priorityOfItem(item)
        }
    }

    fun part2(input: List<String>): Int {
        return input
            .chunked(3)
            .sumOf {
                val badge = findDuplicateBetweenElves(it)
                priorityOfItem(badge)
            }
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
