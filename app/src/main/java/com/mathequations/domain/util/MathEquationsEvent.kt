package com.mathequations.domain.util

sealed class MathEquationsEvent {
    data class SelectMathOperation(val operation: String): MathEquationsEvent()
    data class SelectMathFilter(val filters: MutableMap<String, Boolean>): MathEquationsEvent()
    data object GenerateMathOperation: MathEquationsEvent()
}