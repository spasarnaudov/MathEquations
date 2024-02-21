package com.mathequations.domain.filters.subtraction

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class SubtractionLeadingToNegativeResultFilterTest {
    private lateinit var filter: SubtractionLeadingToNegativeResultFilter

    @Before
    fun setUp() {
        filter = SubtractionLeadingToNegativeResultFilter()
    }

    @Test
    fun `test leading to negative result`() {
        assertTrue(filter.filter(26, 50))
        assertFalse(filter.filter(55, 55))
        assertFalse(filter.filter(7, 5))
    }
}