package com.number_generator.domain.use_case

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class SelectiveNumberGeneratorTest {
    private lateinit var numberGenerator: SelectiveNumberGenerator
    private lateinit var numberGenerator2: SelectiveNumberGenerator
    private lateinit var list: ArrayList<Int>

    @Before
    fun setUp() {
        numberGenerator = SelectiveNumberGenerator()
        list = arrayListOf(
             1,  2,  3,  4,  5,  6,  7,  8,  9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
        )
        numberGenerator2 = SelectiveNumberGenerator(list)
    }

    @Test
    fun testGenerate_WithIncludedNumbers_ReturnsIncludedNumber() {
        numberGenerator.includeNumber(5)
        numberGenerator.includeNumber(10)

        val result = numberGenerator.generate()

        assertTrue(result in listOf(5, 10))
    }

    @Test
    fun testGenerate_WithNoIncludedNumbers_ReturnsNull() {
        val result = numberGenerator.generate()

        assertNull(result)
    }

    @Test
    fun testGenerate_AfterExcludingNumber_DoesNotReturnExcludedNumber() {
        numberGenerator.includeNumber(5)
        numberGenerator.includeNumber(10)
        numberGenerator.excludeNumber(5)

        repeat(10) { // Repeat to increase confidence, though not foolproof
            assertNotEquals(5, numberGenerator.generate())
        }
    }

    @Test
    fun testIncludeNumber_IncludesNumberSuccessfully() {
        numberGenerator.includeNumber(20)

        val result = numberGenerator.generate()

        assertEquals(20, result)
    }

    @Test
    fun testExcludeNumber_ExcludesNumberSuccessfully() {
        numberGenerator.includeNumber(25)
        numberGenerator.excludeNumber(25)

        val result = numberGenerator.generate()

        assertNull(result)
    }

    @Test
    fun testCreationOfUniqueList_UniqueListCreationSuccessfully() {
        val generatedNumber = numberGenerator2.generate()
        generatedNumber?.let { numberGenerator2.excludeNumber(it) }
        assertFalse(numberGenerator2.contains(generatedNumber!!))
    }
}