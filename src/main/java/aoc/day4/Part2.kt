package aoc.day4

import java.io.*

fun main() {
    val lines = File("src/main/java/aoc/day4/input.txt").readLines()

    var xmasOccurences = 0

    for(lineIndex in 1 until lines[0].length - 1) {
        val line = lines[lineIndex]
        for(charInLineIndex in 1 until lines.size - 1) {
            if(line[charInLineIndex] != 'A') {
                continue
            }
            // Check if top left and bottom right include an 'S' and 'M'
            val topLeftAndBottomRight = listOf(lines[lineIndex - 1][charInLineIndex - 1], lines[lineIndex + 1][charInLineIndex + 1])
            if(!(topLeftAndBottomRight.contains('S') && topLeftAndBottomRight.contains('M'))) {
                continue
            }
            // Check if top right and bottom left include an 'S' and 'M'
            val topRightAndBottomLeft = listOf(lines[lineIndex - 1][charInLineIndex + 1], lines[lineIndex + 1][charInLineIndex - 1])
            if(!(topRightAndBottomLeft.contains('S') && topRightAndBottomLeft.contains('M'))) {
                continue
            }
            xmasOccurences++
        }
    }
    println(xmasOccurences)
}
