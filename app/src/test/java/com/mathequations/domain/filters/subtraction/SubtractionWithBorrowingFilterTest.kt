package com.mathequations.domain.filters.subtraction

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class SubtractionWithBorrowingFilterTest {
    private lateinit var filter: SubtractionWithBorrowingFilter

    @Before
    fun setUp() {
        filter = SubtractionWithBorrowingFilter()
    }

    @Test
    fun `test subtraction with borrowing`() {
        assertTrue(filter.filter(1555, 556))
        assertTrue(filter.filter(1555, 565))
        assertTrue(filter.filter(1555, 655))
        assertFalse(filter.filter(1556, 555))
        assertFalse(filter.filter(1565, 555))
        assertFalse(filter.filter(1655, 555))
        assertFalse(filter.filter(500, 500))

        assertTrue(filter.filter(-21, -15))
        assertTrue(filter.filter(-11, -25))

        assertFalse(filter.filter(21, -15))
        assertFalse(filter.filter(11, -25))

        assertFalse(filter.filter(-21, 15))
        assertFalse(filter.filter(-11, 25))
    }
}