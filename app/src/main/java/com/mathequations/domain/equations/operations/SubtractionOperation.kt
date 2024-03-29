package com.mathequations.domain.equations.operations

import com.mathequations.Constants
import com.mathequations.domain.filters.subtraction.SubtractionLeadingToNonZeroResultFilter
import com.mathequations.domain.filters.subtraction.SubtractionLeadingToZeroResultFilter
import com.mathequations.domain.filters.subtraction.SubtractionLeadingToNegativeResultFilter
import com.mathequations.domain.filters.subtraction.SubtractionLeadingToPositiveResultFilter
import com.mathequations.domain.filters.subtraction.SubtractionWithBorrowingFilter
import com.mathequations.domain.filters.subtraction.SubtractionWithoutBorrowingFilter

class SubtractionOperation : MathOperation(
    sign = Constants.MathSign.SIGN_SUBTRACTION,
    filters = listOf(
        SubtractionWithBorrowingFilter(),
        SubtractionWithoutBorrowingFilter(),
        SubtractionLeadingToZeroResultFilter(),
        SubtractionLeadingToNonZeroResultFilter(),
        SubtractionLeadingToNegativeResultFilter(),
        SubtractionLeadingToPositiveResultFilter(),
    )
) {
    override fun calculate(firstNumber: Int, secondNumber: Int): Int {
        return firstNumber - secondNumber
    }
}