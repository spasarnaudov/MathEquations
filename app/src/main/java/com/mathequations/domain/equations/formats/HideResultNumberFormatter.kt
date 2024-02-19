package com.mathequations.domain.equations.formats

import com.mathequations.domain.model.MathEquation

class HideResultNumberFormatter : IEquationFormatter {
    override fun format(equationItem: MathEquation) : String {
        val first = equationItem.firstNumber
        val second = equationItem.secondNumber
        return "$first ${equationItem.mathOperation.sign} $second = ?"
    }
}