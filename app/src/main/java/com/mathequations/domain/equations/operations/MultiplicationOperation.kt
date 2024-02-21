package com.mathequations.domain.equations.operations

import com.mathequations.domain.filters.multiplication.MultiplicationSquareNumbersFilter

class MultiplicationOperation : MathOperation(
    sign = "*",
    filters = listOf(
        MultiplicationSquareNumbersFilter(),
    )
) {
    override fun calculate(firstNumber: Int, secondNumber: Int) : Int {
        return firstNumber * secondNumber
    }

    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return false
    }
}