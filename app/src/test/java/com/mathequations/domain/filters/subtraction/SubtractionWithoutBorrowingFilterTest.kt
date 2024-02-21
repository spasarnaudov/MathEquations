package com.mathequations.domain.filters.subtraction

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class SubtractionWithoutBorrowingFilterTest {
    private lateinit var filter: SubtractionWithoutBorrowingFilter

    @Before
    fun setUp() {
        filter = SubtractionWithoutBorrowingFilter()
    }

    @Test
    fun `test subtraction with borrowing`() {
        assertFalse(filter.filter(1555, 556))
        assertFalse(filter.filter(1555, 565))
        assertFalse(filter.filter(1555, 655))
        assertTrue(filter.filter(1556, 555))
        assertTrue(filter.filter(1565, 555))
        assertTrue(filter.filter(1655, 555))
        assertTrue(filter.filter(500, 500))

        assertFalse(filter.filter(-21, -15))
        assertFalse(filter.filter(-11, -25))

        assertTrue(filter.filter(21, -15))
        assertTrue(filter.filter(11, -25))

        assertTrue(filter.filter(-21, 15))
        assertTrue(filter.filter(-11, 25))
    }
}