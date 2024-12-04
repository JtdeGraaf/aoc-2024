package aoc.day4

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Part1KtTest {

    @Test
    fun testFindVerticalXmases() {
        val lines = listOf("XS", "MA", "AM", "SX")
        val result = findVerticalXmases(lines)
        assertEquals(2, result)
    }

    @Test
    fun testFindHorizontalXmases() {
        val lines = listOf("AAAAXMASAAAAA", "SAMXAAAAAA")
        val result = findHorizontalXmases(lines)
        assertEquals(2, result)
    }

    @Test
    fun testFindDiagonalOccurences() {
        val lines = listOf(
            "XMAS",
            "AMAS",
            "SMAM",
            "XSAS"
        )
        val result = findDiagonalXmases(lines)
        assertEquals(2, result)
    }

}
