package com.mathequations.domain.filters.subtraction

import com.mathequations.domain.filters.AbstractEquationFilter
import com.mathequations.domain.util.MathUtils

class SubtractionWithoutBorrowingFilter : AbstractEquationFilter(
    name = "Subtraction Without Borrowing"
) {
    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return !MathUtils.isSubtractionWithBorrowing(firstNumber, secondNumber)
    }
}