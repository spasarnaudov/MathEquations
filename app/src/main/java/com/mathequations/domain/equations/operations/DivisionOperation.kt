package com.mathequations.domain.equations.operations

import com.mathequations.Constants
import com.mathequations.domain.filters.division.ExactDivisionFilter

class DivisionOperation : MathOperation(
    sign = Constants.MathSign.SIGN_DIVISION,
    filters = listOf(
        ExactDivisionFilter(),
    )
) {
    override fun calculate(firstNumber: Int, secondNumber: Int) : Int {
        return firstNumber / secondNumber
    }

    override fun isValidOperation(firstNumber: Int, secondNumber: Int): Boolean {
        return secondNumber != 0
    }
}