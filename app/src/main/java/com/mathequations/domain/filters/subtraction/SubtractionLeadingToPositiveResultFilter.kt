package com.mathequations.domain.filters.subtraction

import com.mathequations.domain.filters.AbstractEquationFilter

class SubtractionLeadingToPositiveResultFilter : AbstractEquationFilter(
    name = "Subtraction Leading To Positive Result"
) {
    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return firstNumber - secondNumber > 0
    }
}