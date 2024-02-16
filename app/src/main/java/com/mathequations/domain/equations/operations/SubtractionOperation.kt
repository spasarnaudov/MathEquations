package com.mathequations.domain.equations.operations

import com.mathequations.domain.filters.subtraction.SubtractionExcludeZeroResultFilter
import com.mathequations.domain.filters.subtraction.SubtractionNegativeResultFilter
import com.mathequations.domain.filters.subtraction.SubtractionPositiveResultFilter

class SubtractionOperation : MathOperation(
    filters = listOf(
        SubtractionExcludeZeroResultFilter(),
        SubtractionNegativeResultFilter(),
        SubtractionPositiveResultFilter(),
    )
) {
    override fun sign(): String {
        return "-"
    }

    override fun calculate(firstNumber: Int, secondNumber: Int): Int {
        return firstNumber - secondNumber
    }

    override fun filter(firstNumber: Int, secondNumber: Int): Boolean {
        return false
    }
}