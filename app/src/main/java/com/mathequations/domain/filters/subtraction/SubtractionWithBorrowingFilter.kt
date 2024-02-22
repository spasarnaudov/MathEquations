package com.mathequations.domain.filters.subtraction

import com.mathequations.R
import com.mathequations.domain.filters.AbstractEquationFilter
import com.mathequations.domain.util.MathUtils

class SubtractionWithBorrowingFilter : AbstractEquationFilter(
    name = R.string.subtraction_with_borrowing,
) {
    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return MathUtils.isSubtractionWithBorrowing(firstNumber, secondNumber)
    }
}