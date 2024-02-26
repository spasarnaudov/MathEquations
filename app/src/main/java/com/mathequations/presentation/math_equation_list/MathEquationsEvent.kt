package com.mathequations.presentation.math_equation_list

import com.mathequations.domain.filters.AbstractEquationFilter

sealed class MathEquationsEvent {
    data class SelectOperation(val operation: String): MathEquationsEvent()
    data class SelectNegativeInterval(val interval: Int): MathEquationsEvent()
    data class SelectPositiveInterval(val interval: Int): MathEquationsEvent()
    data class SelectFilter(val filters: List<AbstractEquationFilter>): MathEquationsEvent()
    data object GenerateMathOperation: MathEquationsEvent()
}