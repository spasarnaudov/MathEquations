package com.mathequations.domain.filters.division

import com.mathequations.R
import com.mathequations.domain.filters.AbstractEquationFilter

class ExactDivisionFilter : AbstractEquationFilter(
    name = R.string.exact_division,
) {
    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return firstNumber % secondNumber == 0
    }
}