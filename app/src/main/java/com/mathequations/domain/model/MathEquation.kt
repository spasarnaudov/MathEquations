package com.mathequations.domain.model

import com.mathequations.domain.equations.operations.MathOperation

data class MathEquation(val mathOperation: MathOperation, val firstNumber: Int, val secondNumber: Int)