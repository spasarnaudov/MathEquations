package com.mathequations.domain.util

import com.mathequations.domain.equations.operations.AdditionOperation
import com.mathequations.domain.equations.operations.MathOperation
import com.mathequations.domain.filters.AbstractEquationFilter
import com.mathequations.domain.model.MathEquation

data class MathEquationsListState(
    val isLoading: Boolean = false,
    val mathOperation: MathOperation = AdditionOperation(),
    val filters: List<AbstractEquationFilter> = emptyList(),
    val mathEquations: List<MathEquation> = emptyList(),
    val error: String = ""
)
