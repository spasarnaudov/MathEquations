package com.mathequations.domain.filters.subtraction

import com.mathequations.R
import com.mathequations.domain.filters.AbstractEquationFilter

class SubtractionLeadingToPositiveResultFilter : AbstractEquationFilter(
    name = R.string.subtraction_leading_to_positive_result,
) {
    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return firstNumber - secondNumber > 0
    }
}