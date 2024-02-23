package day1

import util.ParseUtil

fun getCalibrationValue(line: String): Int {
    val firstDigit = line.first { it.isDigit() }
    val lastDigit = line.last { it.isDigit() }
    return "$firstDigit$lastDigit".toInt()
}

fun main() {
    val lines = ParseUtil.inputLines(1)

    val part1 = lines.sumOf { getCalibrationValue(it) }
    println("Part 1: $part1")
}
