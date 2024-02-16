package com.mathequations.domain.filters.division

import com.mathequations.domain.filters.IEquationFilter

class DivisionWithZeroRemainderFilter : IEquationFilter {
    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return firstNumber > secondNumber
            && firstNumber % secondNumber == 0
    }

    override fun toString(): String {
        return "Division With Zero Remainder"
    }
}