package com.mathequations.domain.equations.formats

import com.mathequations.domain.model.MathEquation

class HideFirstNumberFormatter : IEquationFormatter {
    override fun format(equationItem: MathEquation) : String {
        val second = equationItem.secondNumber
        val result = equationItem.mathOperation.calculate(equationItem.firstNumber, equationItem.secondNumber)
        return "? ${equationItem.mathOperation.sign} $second = $result"
    }
}