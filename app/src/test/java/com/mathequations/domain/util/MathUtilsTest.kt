package com.mathequations.domain.util

import org.junit.Assert.*
import org.junit.Test

class MathUtilsTest {

    @Test
    fun `test passing the tenth`() {
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
    fun `test without passing the tenth`() {
        assertTrue(MathUtils.nonPassingTheTenth(1, 1)) // 1 + 1 = 2

        assertTrue(MathUtils.nonPassingTheTenth(-1, -1)) // -1 + -1 = -2

        assertTrue(MathUtils.nonPassingTheTenth(7, -5)) // 7 + -5 = 2
        assertFalse(MathUtils.nonPassingTheTenth(5, -7)) // 5 + -7 = -2

        assertTrue(MathUtils.nonPassingTheTenth(-7, 5)) // -7 + 5 = -2
        assertFalse(MathUtils.nonPassingTheTenth(-5, 7)) // -5 + 7 = 2

        assertTrue(MathUtils.nonPassingTheTenth(21, 21)) // 21 + 21 = 42

        assertTrue(MathUtils.nonPassingTheTenth(-21, -21)) // -21 + -21 = -42

        assertTrue(MathUtils.nonPassingTheTenth(27, -25)) // 27 + -25 = 2
        assertFalse(MathUtils.nonPassingTheTenth(25, -27)) // 25 + -27 = -2

        assertTrue(MathUtils.nonPassingTheTenth(-27, 25)) // -27 + 25 = -2
        assertFalse(MathUtils.nonPassingTheTenth(-25, 27)) // -25 + 27 = 2
    }

}