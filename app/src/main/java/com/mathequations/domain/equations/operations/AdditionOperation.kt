package com.mathequations.domain.equations.operations

import com.core.Constants
import com.mathequations.domain.filters.addition.AdditionByPassingTheTenthFilter
import com.mathequations.domain.filters.addition.AdditionWithoutPassingTheTenthFilter

class AdditionOperation : MathOperation(
    sign = Constants.SIGN_ADDITION,
    filters = listOf(
        AdditionByPassingTheTenthFilter(),
        AdditionWithoutPassingTheTenthFilter(),
    )
) {
    override fun calculate(firstNumber: Int, secondNumber: Int) : Int {
        return firstNumber + secondNumber
    }
}