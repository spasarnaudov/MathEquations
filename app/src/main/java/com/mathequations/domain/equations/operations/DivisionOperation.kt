package com.mathequations.domain.equations.operations

import com.mathequations.domain.filters.division.DivisionWithZeroRemainderFilter

class DivisionOperation : MathOperation(
    sign = "/",
    filters = listOf(
        DivisionWithZeroRemainderFilter(),
    )
) {
    override fun calculate(firstNumber: Int, secondNumber: Int) : Int {
        return firstNumber / secondNumber
    }

    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return secondNumber == 0
            || secondNumber > firstNumber
            || firstNumber % secondNumber != 0
    }
}