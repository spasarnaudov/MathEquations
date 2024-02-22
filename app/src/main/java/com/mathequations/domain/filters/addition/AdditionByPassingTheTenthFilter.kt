package com.mathequations.domain.filters.addition

import com.mathequations.R
import com.mathequations.domain.filters.AbstractEquationFilter
import com.mathequations.domain.util.MathUtils

class AdditionByPassingTheTenthFilter : AbstractEquationFilter(
    name = R.string.addition_by_passing_the_tenth,
) {
    override fun filter(firstNumber: Int, secondNumber: Int) : Boolean {
        return MathUtils.passingTheTenth(firstNumber, secondNumber)
    }
}