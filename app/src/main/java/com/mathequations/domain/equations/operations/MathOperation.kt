package com.mathequations.domain.equations.operations

import com.mathequations.domain.filters.IEquationFilter

abstract class MathOperation(
    val filters: List<IEquationFilter>
) : IEquationFilter {
    abstract fun sign() : String
    abstract fun calculate(firstNumber: Int, secondNumber: Int) : Int
}