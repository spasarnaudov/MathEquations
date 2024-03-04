package com.mathequations.domain.use_case

import com.mathequations.Constants
import com.core.presentation.model.SegmentedButtonItem
import com.mathequations.domain.equations.operations.AdditionOperation
import com.mathequations.domain.equations.operations.DivisionOperation
import com.mathequations.domain.equations.operations.MathOperation
import com.mathequations.domain.equations.operations.MultiplicationOperation
import com.mathequations.domain.equations.operations.SubtractionOperation

class GetMathOperationsUseCase {
    operator fun invoke(): List<SegmentedButtonItem<MathOperation>> {
        return listOf(
            SegmentedButtonItem(Constants.MathSign.SIGN_ADDITION, AdditionOperation()),
            SegmentedButtonItem(Constants.MathSign.SIGN_SUBTRACTION, SubtractionOperation()),
            SegmentedButtonItem(Constants.MathSign.SIGN_MULTIPLICATION, MultiplicationOperation()),
            SegmentedButtonItem(Constants.MathSign.SIGN_DIVISION, DivisionOperation()),
        )
    }
}