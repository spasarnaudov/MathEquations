package com.mathequations.presentation.math_equation_list

import com.mathequations.domain.filters.AbstractEquationFilter

sealed class MathEquationsEvent {
    data class SelectOperation(val operation: String): MathEquationsEvent()
    data class SelectInterval(val interval: String): MathEquationsEvent()
    data class SelectFilter(val filters: List<AbstractEquationFilter>): MathEquationsEvent()
    data object GenerateMathOperation: MathEquationsEvent()
}