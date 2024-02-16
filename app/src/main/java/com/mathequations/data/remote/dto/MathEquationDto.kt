package com.mathequations.data.remote.dto

import com.mathequations.domain.equations.operations.MathOperation
import com.mathequations.domain.model.MathEquation

data class MathEquationDto(
    val id: Int,
    val mathOperation: MathOperation,
    val firstNumber: Int,
    val secondNumber: Int
)

fun MathEquationDto.toEquationItem(): MathEquation {
    return MathEquation(
        mathOperation = mathOperation,
        firstNumber = firstNumber,
        secondNumber = secondNumber,
    )
}
