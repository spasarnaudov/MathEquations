package com.mathequations.domain.filters.multiplication

import com.mathequations.R
import com.mathequations.domain.filters.AbstractEquationFilter
import kotlin.math.abs

class MultiplicationSquareNumbersFilter : AbstractEquationFilter(
    name = R.string.multiplication_square_numbers,
) {
    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return abs(firstNumber) == abs(secondNumber)
    }
}