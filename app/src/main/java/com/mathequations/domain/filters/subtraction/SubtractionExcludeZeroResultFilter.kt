package com.mathequations.domain.filters.subtraction

import com.mathequations.domain.filters.AbstractEquationFilter

class SubtractionExcludeZeroResultFilter : AbstractEquationFilter(
    name = "Subtraction Exclude Zero Result"
) {
    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return firstNumber - secondNumber != 0
    }
}