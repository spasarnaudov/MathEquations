package com.mathequations.domain.filters.common

import com.mathequations.domain.filters.AbstractEquationFilter

class NegativeNumbersFilter : AbstractEquationFilter(
    name = "Negative Numbers",
) {
    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return firstNumber < 0 && secondNumber < 0
    }
}