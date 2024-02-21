package com.mathequations.domain.util

import com.mathequations.domain.filters.AbstractEquationFilter

sealed class MathEquationsEvent {
    data class SelectMathOperation(val operation: String): MathEquationsEvent()
    data class SelectMathFilter(val filters: List<AbstractEquationFilter>): MathEquationsEvent()
    data object GenerateMathOperation: MathEquationsEvent()
}