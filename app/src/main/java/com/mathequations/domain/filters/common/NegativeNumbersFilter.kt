package com.mathequations.domain.filters.common

import com.mathequations.domain.filters.IEquationFilter

class NegativeNumbersFilter : IEquationFilter {
    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return firstNumber < 0 && secondNumber < 0
    }

    override fun toString(): String {
        return "Negative Numbers"
    }
}