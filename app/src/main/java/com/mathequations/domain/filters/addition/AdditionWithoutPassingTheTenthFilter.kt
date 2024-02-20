package com.mathequations.domain.filters.addition

import com.mathequations.domain.filters.AbstractEquationFilter
import com.mathequations.domain.util.MathUtils

class AdditionWithoutPassingTheTenthFilter : AbstractEquationFilter(
    name = "Addition Without Passing The Tenth",
) {
    override fun filter(firstNumber: Int, secondNumber: Int) : Boolean {
        return MathUtils.nonPassingTheTenth(firstNumber, secondNumber)
    }
}