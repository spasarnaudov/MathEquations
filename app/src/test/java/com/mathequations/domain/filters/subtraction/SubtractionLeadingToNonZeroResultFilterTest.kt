package com.mathequations.domain.filters.subtraction

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class SubtractionLeadingToNonZeroResultFilterTest {
    private lateinit var filter: SubtractionLeadingToNonZeroResultFilter

    @Before
    fun setUp() {
        filter = SubtractionLeadingToNonZeroResultFilter()
    }

    @Test
    fun `test leading to non zero result`() {
        assertTrue(filter.filter(500, 50))
        assertFalse(filter.filter(55, 55))
        assertTrue(filter.filter(50, 55))
    }
}