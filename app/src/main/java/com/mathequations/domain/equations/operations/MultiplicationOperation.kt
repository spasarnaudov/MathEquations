package com.mathequations.domain.equations.operations

import com.mathequations.Constants
import com.mathequations.domain.filters.multiplication.MultiplicationSquareNumbersFilter

class MultiplicationOperation : MathOperation(
    sign = Constants.MathSign.SIGN_MULTIPLICATION,
    filters = listOf(
        MultiplicationSquareNumbersFilter(),
    )
) {
    override fun calculate(firstNumber: Int, secondNumber: Int) : Int {
        return firstNumber * secondNumber
    }
}