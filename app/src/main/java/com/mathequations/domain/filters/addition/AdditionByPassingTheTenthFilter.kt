package com.mathequations.domain.filters.addition

import com.mathequations.domain.filters.AbstractEquationFilter
import com.mathequations.domain.util.MathUtils

class AdditionByPassingTheTenthFilter : AbstractEquationFilter(
    name = "Addition By Passing The Tenth",
) {
    override fun filter(firstNumber: Int, secondNumber: Int) : Boolean {
        return MathUtils.passingTheTenth(firstNumber, secondNumber)
    }
}