package com.mathequations.domain.filters.addition

import com.mathequations.domain.filters.AbstractEquationFilter

open class AdditionByPassingTheTenthFilter : AbstractEquationFilter(
    name = "Addition By Passing The Tenth",
) {
    override fun filter(firstNumber: Int, secondNumber: Int) : Boolean {
        if (firstNumber % 10 + secondNumber % 10 >= 10) {
            return true
        }
        if (firstNumber / 10 == 0 || secondNumber / 10 == 0) {
            return false
        }
        return filter(firstNumber / 10, secondNumber / 10)
    }
}