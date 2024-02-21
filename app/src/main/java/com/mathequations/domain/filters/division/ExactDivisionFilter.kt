package com.mathequations.domain.filters.division

import com.mathequations.domain.filters.AbstractEquationFilter

class ExactDivisionFilter : AbstractEquationFilter(
    name = "Exact Division"
) {
    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return firstNumber % secondNumber == 0
    }
}