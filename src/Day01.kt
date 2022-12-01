fun main() {
    fun caloriesPerElve(rucksack: String) =
        rucksack.replace(",", "")
            .trim()
            .split(" ")
            .sumOf { it.toInt() }


    fun getElvesList(input: List<String>): List<String> =
        input.toString()
            .removePrefix("[")
            .removeSuffix("]")
            .split(" ,")

    fun part1(input: List<String>): Int {
        val elves = getElvesList(input)
        return elves.map { caloriesPerElve(it) }.max()
    }

    fun part2(input: List<String>): Int {
        val elves = getElvesList(input)
        return  elves
            .map { caloriesPerElve(it) }
            .sortedDescending()
            .slice(0..2)
            .sum()
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
