package com.mathequations.domain.equations.operations

import com.mathequations.domain.filters.IEquationFilter
import com.mathequations.domain.filters.addition.AdditionByPassingTheTenthFilter
import com.mathequations.domain.filters.addition.AdditionWithoutPassingTheTenthFilter

class AdditionOperation : MathOperation(
    filters = listOf(
        AdditionByPassingTheTenthFilter(),
        AdditionWithoutPassingTheTenthFilter(),
    )
) {
    override fun sign(): String {
        return "+"
    }

    override fun calculate(firstNumber: Int, secondNumber: Int) : Int {
        return firstNumber + secondNumber
    }

    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return false
    }
}