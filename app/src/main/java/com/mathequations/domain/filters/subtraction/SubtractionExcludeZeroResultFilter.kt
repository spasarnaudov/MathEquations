package com.mathequations.domain.filters.subtraction

import com.mathequations.domain.filters.IEquationFilter

class SubtractionExcludeZeroResultFilter : IEquationFilter {
    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return firstNumber - secondNumber != 0
    }

    override fun toString(): String {
        return "Subtraction Exclude Zero Result"
    }
}