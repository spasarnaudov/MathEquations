package com.mathequations.domain.filters.addition

import com.mathequations.domain.util.MathUtils
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AdditionWithoutPassingTheTenthFilterTest {

    private lateinit var filter: AdditionWithoutPassingTheTenthFilter

    @Before
    fun setUp() {
        filter = AdditionWithoutPassingTheTenthFilter()
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