data class Section(
    val start: Int,
    val end: Int
)


fun main() {

    // horizontal arranged based on starting point
    fun parseIntoArrangedSections(input: String): Pair<Section, Section> {
        val elves = input.split(",")
        val rawSectionA = elves[0].split("-")
        val rawSectionB = elves[1].split("-")
        val sectionA = Section(rawSectionA[0].toInt(), rawSectionA[1].toInt())
        val sectionB = Section(rawSectionB[0].toInt(), rawSectionB[1].toInt())

        return if (sectionA.start <= sectionB.start) {
            Pair(sectionA, sectionB)
        } else {
            Pair(sectionB, sectionA)
        }
    }

    fun fullyContains(left: Section, right: Section): Boolean {
        if (left.start == right.start || left.end == right.end) return true
        return left.end >= right.end
    }

    fun isOverlapping(left: Section, right: Section): Boolean {
        return (right.start <= left.end && right.start >= left.start )
    }

    fun part1(input: List<String>): Int {
        return input.sumOf { line ->
            val sections = parseIntoArrangedSections(line)
            if (fullyContains(sections.first, sections.second)) {
                1.0
            } else {
                0.0
            }
        }.toInt()
    }

    fun part2(input: List<String>): Int {
        return input.sumOf { line ->
            val sections = parseIntoArrangedSections(line)
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


