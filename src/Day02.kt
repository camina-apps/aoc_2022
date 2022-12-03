fun main() {

    fun outcomeRound(opponent: String, you: String): Int {
        when (you) {
            "A" -> {
                if (opponent == "A") return 3
            } // rock
            "B" -> {
                if (opponent == "B") return 3
            } // paper
            "C" -> {
                if (opponent == "C") return 3
            } // scissor
        }
        when (you) {
            "A" -> {
                if (opponent == "C") return 6
            } // rock - scissor
            "B" -> {
                if (opponent == "A") return 6
            } // paper - rock
            "C" -> {
                if (opponent == "B") return 6
            } // scissor - paper
        }
        return 0
    }

    fun scoreShape(shape: String): Int {
        return when (shape) {
            "X", "A" -> 1
            "Y", "B" -> 2
            "Z", "C" -> 3
            else -> 0
        }
    }

    fun getLooseShape(opponent: String): String {
        return when (opponent) {
            "A" -> "C"
            "B" -> "A"
            "C" -> "B"
            else -> ""
        }
    }

    fun getWinShape(opponent: String): String {
        return when (opponent) {
            "A" -> "B"
            "B" -> "C"
            "C" -> "A"
            else -> ""
        }
    }

    fun mapOutcomeToShape(oppponent: String, outcome: String): String {
        return when (outcome) {
            "Y" -> oppponent
            "X" -> getLooseShape(oppponent)
            "Z" -> getWinShape(oppponent)
            else -> ""
        }
    }

    fun totalScoreRound(opponent: String, you: String): Int {
        return outcomeRound(opponent, you) + scoreShape(you)
    }

    fun part1(input: List<String>): Int {
        val strategyGuide = input
        var sum = 0
        strategyGuide.forEach {
            sum += totalScoreRound(it.take(1), it.takeLast(1))
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        input.forEach {
            val opponent = it.take(1)
            val outcome = it.takeLast(1)
            val you = mapOutcomeToShape(opponent, outcome)
            sum += totalScoreRound(opponent, you)
        }
        return sum

    }

    val testInput = readInput("Day02_test")
//    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
//    println(part1(input))
    println(part2(input))
}
