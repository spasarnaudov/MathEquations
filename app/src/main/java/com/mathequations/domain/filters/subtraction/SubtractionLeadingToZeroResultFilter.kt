package com.mathequations.domain.filters.subtraction

import com.mathequations.domain.filters.AbstractEquationFilter

class SubtractionLeadingToZeroResultFilter : AbstractEquationFilter(
    name = "Subtraction Leading To Zero Result"
) {
    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return firstNumber - secondNumber == 0
    }
}