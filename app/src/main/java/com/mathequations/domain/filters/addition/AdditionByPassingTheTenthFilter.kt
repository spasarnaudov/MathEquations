package com.mathequations.domain.filters.addition

import com.mathequations.domain.filters.IEquationFilter

open class AdditionByPassingTheTenthFilter : IEquationFilter {
    override fun filter(firstNumber: Int, secondNumber: Int) : Boolean {
        if (firstNumber % 10 + secondNumber % 10 >= 10) {
            return true
        }
        if (firstNumber / 10 == 0 || secondNumber / 10 == 0) {
            return false
        }
        return filter(firstNumber / 10, secondNumber / 10)
    }

    override fun toString(): String {
        return "Addition By Passing The Tenth"
    }
}