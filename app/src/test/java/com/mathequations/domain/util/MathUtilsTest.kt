package com.mathequations.domain.util

import org.junit.Assert.*
import org.junit.Test

class MathUtilsTest {

    @Test
    fun `test addition with passing the tenth`() {
        assertFalse(MathUtils.passingTheTenth(1, 1)) // 1 + 1 = 2

        assertFalse(MathUtils.passingTheTenth(-1, -1)) // -1 + -1 = -2

        assertFalse(MathUtils.passingTheTenth(7, -5)) // 7 + -5 = 2
        assertTrue(MathUtils.passingTheTenth(5, -7)) // 5 + -7 = -2

        assertFalse(MathUtils.passingTheTenth(-7, 5)) // -7 + 5 = -2
        assertTrue(MathUtils.passingTheTenth(-5, 7)) // -5 + 7 = 2

        assertFalse(MathUtils.passingTheTenth(21, 21)) // 21 + 21 = 42

        assertFalse(MathUtils.passingTheTenth(-21, -21)) // -21 + -21 = -42

        assertFalse(MathUtils.passingTheTenth(27, -25)) // 27 + -25 = 2
        assertTrue(MathUtils.passingTheTenth(25, -27)) // 25 + -27 = -2

        assertFalse(MathUtils.passingTheTenth(-27, 25)) // -27 + 25 = -2
        assertTrue(MathUtils.passingTheTenth(-25, 27)) // -25 + 27 = 2
    }

    @Test
    fun `test subtraction with borrowing`() {
        assertTrue(MathUtils.isSubtractionWithBorrowing(1555, 556))
        assertTrue(MathUtils.isSubtractionWithBorrowing(1555, 565))
        assertTrue(MathUtils.isSubtractionWithBorrowing(1555, 655))
        assertFalse(MathUtils.isSubtractionWithBorrowing(1556, 555))
        assertFalse(MathUtils.isSubtractionWithBorrowing(1565, 555))
        assertFalse(MathUtils.isSubtractionWithBorrowing(1655, 555))
        assertFalse(MathUtils.isSubtractionWithBorrowing(500, 500))

        assertTrue(MathUtils.isSubtractionWithBorrowing(-21, -15))
        assertTrue(MathUtils.isSubtractionWithBorrowing(-11, -25))

        assertFalse(MathUtils.isSubtractionWithBorrowing(21, -15))
        assertFalse(MathUtils.isSubtractionWithBorrowing(11, -25))

        assertFalse(MathUtils.isSubtractionWithBorrowing(-21, 15))
        assertFalse(MathUtils.isSubtractionWithBorrowing(-11, 25))
    }

}