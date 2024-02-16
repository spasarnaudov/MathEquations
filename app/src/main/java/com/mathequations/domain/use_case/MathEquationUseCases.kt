package com.mathequations.domain.use_case

data class MathEquationUseCases(
    val generateMathEquationsUseCase: GenerateMathEquationsUseCase,
    val getMathOperationsUseCase: GetMathOperationsUseCase,
    val getFiltersByNames: GetFiltersByNamesUseCase,
)
