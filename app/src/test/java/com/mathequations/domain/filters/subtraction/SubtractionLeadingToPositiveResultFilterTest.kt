package com.mathequations.domain.filters.subtraction

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class SubtractionLeadingToPositiveResultFilterTest {
    private lateinit var filter: SubtractionLeadingToPositiveResultFilter

    @Before
    fun setUp() {
        filter = SubtractionLeadingToPositiveResultFilter()
    }

    @Test
    fun `test subtraction with borrowing`() {
        assertTrue(filter.filter(12, 3))
        assertFalse(filter.filter(6, 6))
        assertFalse(filter.filter(5, 7))
    }
}