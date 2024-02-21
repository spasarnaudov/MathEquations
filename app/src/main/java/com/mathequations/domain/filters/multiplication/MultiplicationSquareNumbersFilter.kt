package com.mathequations.domain.filters.multiplication

import com.mathequations.domain.filters.AbstractEquationFilter
import kotlin.math.abs

class MultiplicationSquareNumbersFilter : AbstractEquationFilter(
    name = "Multiplication Square Numbers"
) {
    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return abs(firstNumber) == abs(secondNumber)
    }
}