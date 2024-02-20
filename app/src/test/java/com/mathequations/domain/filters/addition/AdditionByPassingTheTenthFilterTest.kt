package com.mathequations.domain.filters.addition

import com.mathequations.domain.util.MathUtils
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AdditionByPassingTheTenthFilterTest {

    private lateinit var filter: AdditionByPassingTheTenthFilter

    @Before
    fun setUp() {
        filter = AdditionByPassingTheTenthFilter()
    }

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

}