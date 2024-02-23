package day1

import util.ParseUtil

fun getCalibrationValue(line: String): Int {
    val firstDigit = line.first { it.isDigit() }
    val lastDigit = line.last { it.isDigit() }
    return "$firstDigit$lastDigit".toInt()
}

private val digitMappings = mapOf(
    "one" to 1,
    "two" to 2,
    "three" to 3,
    "four" to 4,
    "five" to 5,
    "six" to 6,
    "seven" to 7,
    "eight" to 8,
    "nine" to 9,
)
private val digitRegex = Regex("(?=(\\d|one|two|three|four|five|six|seven|eight|nine)).")

fun getUpdatedCalibrationValue(line: String): Int {
    val digits = digitRegex.findAll(line).map { it.groupValues[1] }.toList()

    val firstDigitText = digits.first()
    val firstDigit = digitMappings[firstDigitText] ?: firstDigitText

    val lastDigitText = digits.last()
    val lastDigit = digitMappings[lastDigitText] ?: lastDigitText

    return "$firstDigit$lastDigit".toInt()
}

fun main() {
    val lines = ParseUtil.inputLines(1)

    val part2 = lines.sumOf { getUpdatedCalibrationValue(it) }
    println("Part 2: $part2")
}
