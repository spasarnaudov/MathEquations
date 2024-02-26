package com.mathequations.domain.model

import com.mathequations.domain.use_case.GenerateMathEquationsUseCase
import com.mathequations.domain.use_case.GetMathOperationsUseCase

data class MathEquationUseCases(
    val generateMathEquationsUseCase: GenerateMathEquationsUseCase,
    val getMathOperationsUseCase: GetMathOperationsUseCase,
)
