package com.mathequations.domain.filters.subtraction

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class SubtractionLeadingToZeroResultFilterTest {
    private lateinit var filter: SubtractionLeadingToZeroResultFilter

    @Before
    fun setUp() {
        filter = SubtractionLeadingToZeroResultFilter()
    }

    @Test
    fun `test subtraction with borrowing`() {
        assertTrue(filter.filter(55, 55))
        assertFalse(filter.filter(500, 50))
        assertFalse(filter.filter(50, 55))
    }
}