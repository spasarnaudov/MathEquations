package com.mathequations.domain.filters.subtraction

import com.mathequations.domain.filters.AbstractEquationFilter

class SubtractionNegativeResultFilter : AbstractEquationFilter(
    name = "Subtraction Negative Result"
) {
    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return firstNumber - secondNumber < 0
    }
}