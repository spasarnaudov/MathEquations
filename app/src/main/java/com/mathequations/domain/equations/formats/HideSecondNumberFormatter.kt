package com.mathequations.domain.equations.formats

import com.mathequations.domain.model.MathEquation

class HideSecondNumberFormatter : IEquationFormatter {
    override fun format(equationItem: MathEquation) : String {
        val first = equationItem.firstNumber
        val result = equationItem.mathOperation.calculate(equationItem.firstNumber, equationItem.secondNumber)
        return "$first ${equationItem.mathOperation.sign} ? = $result"
    }
}