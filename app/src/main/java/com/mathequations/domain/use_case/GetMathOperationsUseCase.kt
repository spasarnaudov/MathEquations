package com.mathequations.domain.use_case

import com.mathequations.domain.equations.operations.AdditionOperation
import com.mathequations.domain.equations.operations.DivisionOperation
import com.mathequations.domain.equations.operations.MathOperation
import com.mathequations.domain.equations.operations.MultiplicationOperation
import com.mathequations.domain.equations.operations.SubtractionOperation

class GetMathOperationsUseCase {
    operator fun invoke(): List<MathOperation> {
        return listOf(
            AdditionOperation(),
            SubtractionOperation(),
            MultiplicationOperation(),
            DivisionOperation(),
        )
    }
}