package com.mathequations.domain.equations.operations

import com.mathequations.domain.filters.common.ExcludeZeroNumbersFilter
import com.mathequations.domain.filters.common.NegativeNumbersFilter
import com.mathequations.domain.filters.common.PositiveNumbersFilter

class MultiplicationOperation : MathOperation(
    filters = listOf(
        ExcludeZeroNumbersFilter(),
        NegativeNumbersFilter(),
        PositiveNumbersFilter(),
    )
) {
    override fun sign(): String {
        return "*"
    }

    override fun calculate(firstNumber: Int, secondNumber: Int) : Int {
        return firstNumber * secondNumber
    }

    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return false
    }
}