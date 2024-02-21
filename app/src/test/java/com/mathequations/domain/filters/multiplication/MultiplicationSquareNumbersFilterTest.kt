package com.mathequations.domain.filters.multiplication

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MultiplicationSquareNumbersFilterTest {
    private lateinit var filter: MultiplicationSquareNumbersFilter

    @Before
    fun setUp() {
        filter = MultiplicationSquareNumbersFilter()
    }

    @Test
    fun `test square numbers`() {
        assertTrue(filter.filter(3, 3))
        assertTrue(filter.filter(-3, 3))
        assertTrue(filter.filter(3, -3))
        assertTrue(filter.filter(-3, -3))

        assertFalse(filter.filter(4, 3))
        assertFalse(filter.filter(-4, 3))
        assertFalse(filter.filter(4, -3))
        assertFalse(filter.filter(-4, -3))
    }
}