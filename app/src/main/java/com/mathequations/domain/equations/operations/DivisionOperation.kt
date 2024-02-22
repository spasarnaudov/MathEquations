package com.mathequations.domain.equations.operations

import com.core.Constants
import com.mathequations.domain.filters.division.ExactDivisionFilter

class DivisionOperation : MathOperation(
    sign = Constants.SIGN_DIVISION,
    filters = listOf(
        ExactDivisionFilter(),
    )
) {
    override fun calculate(firstNumber: Int, secondNumber: Int) : Int {
        return firstNumber / secondNumber
    }

    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return secondNumber == 0
    }
}