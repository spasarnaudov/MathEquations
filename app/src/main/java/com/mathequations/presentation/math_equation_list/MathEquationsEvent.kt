package com.mathequations.presentation.math_equation_list

import com.core.presentation.model.SegmentedButtonItem
import com.mathequations.domain.equations.operations.MathOperation
import com.mathequations.domain.filters.AbstractEquationFilter
import com.mathequations.domain.model.NumbersInterval

sealed class MathEquationsEvent {
    data class SelectOperation(val operation: SegmentedButtonItem<MathOperation>): MathEquationsEvent()
    data class SelectNegativeInterval(val interval: SegmentedButtonItem<NumbersInterval>): MathEquationsEvent()
    data class SelectFilter(val filters: List<AbstractEquationFilter>): MathEquationsEvent()
    data object GenerateMathOperation: MathEquationsEvent()
}