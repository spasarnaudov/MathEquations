package com.mathequations.domain.equations.operations

import com.mathequations.domain.filters.AbstractEquationFilter

abstract class MathOperation(
    val sign: String,
    val filters: List<AbstractEquationFilter>
) {
    abstract fun calculate(firstNumber: Int, secondNumber: Int) : Int

    open fun isValidOperation(firstNumber: Int, secondNumber: Int) : Boolean {
        return true
    }
}