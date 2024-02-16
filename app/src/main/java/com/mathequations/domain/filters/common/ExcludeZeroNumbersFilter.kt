package com.mathequations.domain.filters.common

import com.mathequations.domain.filters.IEquationFilter

class ExcludeZeroNumbersFilter : IEquationFilter {
    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return firstNumber != 0 && secondNumber != 0
    }

    override fun toString(): String {
        return "Exclude Zero Numbers"
    }
}