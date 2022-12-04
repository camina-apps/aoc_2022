data class Section(
    val start: Int,
    val end: Int
)


fun main() {

    fun parseIntoSections(input: String): Pair<Section, Section> {
        val elves = input.split(",")
        val rawSectionA = elves[0].split("-")
        val rawSectionB = elves[1].split("-")
        val sectionA = Section(rawSectionA[0].toInt(), rawSectionA[1].toInt())
        val sectionB = Section(rawSectionB[0].toInt(), rawSectionB[1].toInt())
        return Pair(sectionA, sectionB)
    }

    fun fullyContains(sectionA: Section, sectionB: Section): Boolean {
        if (sectionA.start == sectionB.start || sectionA.end == sectionB.end) return true

        var left: Section
        var right: Section
        if (sectionA.start <= sectionB.start) {
            left = sectionA
            right = sectionB
        } else {
            left = sectionB
            right = sectionA
        }
        return left.end >= right.end
    }

    fun isOverlapping(sectionA: Section, sectionB: Section): Boolean {
        var left: Section
        var right: Section
        if (sectionA.start <= sectionB.start) {
            left = sectionA
            right = sectionB
        } else {
            left = sectionB
            right = sectionA
        }

        return (right.start <= left.end && right.start >= left.start )
    }

    fun part1(input: List<String>): Int {
        return input.sumOf { line ->
            val sections = parseIntoSections(line)
            if (fullyContains(sections.first, sections.second)) {
                1.0
            } else {
                0.0
            }
        }.toInt()
    }

    fun part2(input: List<String>): Int {
        return input.sumOf { line ->
            val sections = parseIntoSections(line)
            if (isOverlapping(sections.first, sections.second)) {
                1.0
            } else {
                0.0
            }
        }.toInt()
    }

    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}


