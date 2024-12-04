package aoc.day4

import java.io.*

fun main() {
    val lines = File("src/main/java/aoc/day4/input.txt").readLines()

    var xmasOccurences = 0
    xmasOccurences += findHorizontalXmases(lines)
    xmasOccurences += findVerticalXmases(lines)
    xmasOccurences += findDiagonalXmases(lines)

    println(xmasOccurences)
}

fun findDiagonalXmases(lines: List<String>): Int {
    var diagonalOccurences = 0

    // Find top left to bottom right diagonal occurrences
    for (startRow in lines.indices) {
        var diagonalLine = ""
        var row = startRow
        var col = 0
        while (row < lines.size && col < lines[0].length) {
            diagonalLine += lines[row][col]
            row++
            col++
        }
        diagonalOccurences += diagonalLine.split("XMAS").size - 1
        diagonalOccurences += diagonalLine.split("SAMX").size - 1
    }
    for (startCol in 1 until lines[0].length) {
        var diagonalLine = ""
        var row = 0
        var col = startCol
        while (row < lines.size && col < lines[0].length) {
            diagonalLine += lines[row][col]
            row++
            col++
        }
        diagonalOccurences += diagonalLine.split("XMAS").size - 1
        diagonalOccurences += diagonalLine.split("SAMX").size - 1
    }

    // Find top right to bottom left diagonal occurrences
    for (startRow in lines.indices) {
        var diagonalLine = ""
        var row = startRow
        var col = lines[0].length - 1
        while (row < lines.size && col >= 0) {
            diagonalLine += lines[row][col]
            row++
            col--
        }
        diagonalOccurences += diagonalLine.split("XMAS").size - 1
        diagonalOccurences += diagonalLine.split("SAMX").size - 1
    }
    for (startCol in lines[0].lastIndex - 1 downTo 0) {
        var diagonalLine = ""
        var row = 0
        var col = startCol
        while (row < lines.size && col >= 0) {
            diagonalLine += lines[row][col]
            row++
            col--
        }
        diagonalOccurences += diagonalLine.split("XMAS").size - 1
        diagonalOccurences += diagonalLine.split("SAMX").size - 1
    }

    return diagonalOccurences
}


fun findVerticalXmases(lines: List<String>): Int {
    var verticalOccurences = 0
    for (charIndex in lines[0].indices) {
        var verticalLine = ""
        for (lineIndex in lines.indices) {
            val line = lines[lineIndex]
            verticalLine += line[charIndex]
        }
        verticalOccurences += verticalLine.split("XMAS").size - 1
        verticalOccurences += verticalLine.split("SAMX").size - 1
    }
    return verticalOccurences
}

fun findHorizontalXmases(lines: List<String>): Int {
    var horizontalOccurences = 0
    for (line in lines) {
        horizontalOccurences += line.split("XMAS").size - 1
        horizontalOccurences += line.split("SAMX").size - 1
    }
    return horizontalOccurences
}
