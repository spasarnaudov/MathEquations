package com.mathequations.domain.filters.subtraction

import com.mathequations.domain.filters.AbstractEquationFilter

class SubtractionLeadingToNegativeResultFilter : AbstractEquationFilter(
    name = "Subtraction Leading To Negative Result"
) {
    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return firstNumber - secondNumber < 0
    }
}