package com.mathequations.domain.filters.addition

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AdditionByPassingTheTenthFilterTest {

    private lateinit var filter: AdditionByPassingTheTenthFilter

    @Before
    fun setup() {
        filter = AdditionByPassingTheTenthFilter()
    }

    @Test
    fun `test filter with sum of last digits greater than or equal to 10`() {
        assertTrue(filter.filter(5, 5)) // 5 + 5 = 10
        assertTrue(filter.filter(28, 82)) // 8 + 2 = 10
    }

    @Test
    fun `test filter with sum of last digits less than -10`() {
        assertTrue(filter.filter(-56, -55)) // -6 + -5 = -11
    }

    @Test
    fun `test filter with single-digit numbers`() {
        assertFalse(filter.filter(0, 9)) // Single-digit check
        assertFalse(filter.filter(9, 0)) // Single-digit check
    }

    @Test
    fun `test filter with recursion for multiple digits`() {
        assertFalse(filter.filter(111, 111)) // Recursive check, all digits are 1, so the sum never reaches 10
        assertTrue(filter.filter(29, 81)) // Recursive check, eventually the sum of digits is 10
    }
}