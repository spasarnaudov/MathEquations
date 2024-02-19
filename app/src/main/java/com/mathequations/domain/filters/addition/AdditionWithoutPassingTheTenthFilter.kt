package com.mathequations.domain.filters.addition

import com.mathequations.domain.filters.AbstractEquationFilter

class AdditionWithoutPassingTheTenthFilter : AbstractEquationFilter(
    name = "Addition Without Passing The Tenth",
) {
    override fun filter(firstNumber: Int, secondNumber: Int) : Boolean {
        if (firstNumber % 10 + secondNumber % 10 >= 10) {
            return false
        }
        if (firstNumber / 10 == 0 || secondNumber / 10 == 0) {
            return true
        }
        return !filter(firstNumber / 10, secondNumber / 10)
    }
}