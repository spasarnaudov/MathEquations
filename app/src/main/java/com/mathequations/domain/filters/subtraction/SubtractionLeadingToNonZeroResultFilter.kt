package com.mathequations.domain.filters.subtraction

import com.mathequations.domain.filters.AbstractEquationFilter

class SubtractionLeadingToNonZeroResultFilter : AbstractEquationFilter(
    name = "Subtraction Leading To Non Zero Result"
) {
    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return firstNumber - secondNumber != 0
    }
}