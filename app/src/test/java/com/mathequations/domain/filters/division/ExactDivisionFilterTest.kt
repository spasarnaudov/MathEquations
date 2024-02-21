package com.mathequations.domain.filters.division

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ExactDivisionFilterTest {
    private lateinit var filter: ExactDivisionFilter

    @Before
    fun setUp() {
        filter = ExactDivisionFilter()
    }

    @Test
    fun `test square numbers`() {
        assertTrue(filter.filter(6, 3))
        assertTrue(filter.filter(-6, 3))
        assertTrue(filter.filter(6, -3))
        assertTrue(filter.filter(-6, -3))

        assertFalse(filter.filter(4, 3))
        assertFalse(filter.filter(-4, 3))
        assertFalse(filter.filter(4, -3))
        assertFalse(filter.filter(-4, -3))
    }
}