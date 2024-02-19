package com.mathequations.domain.filters.division

import com.mathequations.domain.filters.AbstractEquationFilter

class DivisionWithZeroRemainderFilter : AbstractEquationFilter(
    name = "Division With Zero Remainder"
) {
    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return firstNumber > secondNumber
            && firstNumber % secondNumber == 0
    }
}