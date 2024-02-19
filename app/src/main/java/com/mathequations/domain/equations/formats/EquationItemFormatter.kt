package com.mathequations.domain.equations.formats

import com.mathequations.domain.model.MathEquation

class EquationItemFormatter : IEquationFormatter {
    override fun format(equationItem: MathEquation) : String {
        return "${equationItem.firstNumber} ${equationItem.mathOperation.sign} ${equationItem.secondNumber} = ${equationItem.mathOperation.calculate(equationItem.firstNumber, equationItem.secondNumber)}"
    }
}