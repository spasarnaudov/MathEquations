package com.mathequations.domain.equations.formats

import com.mathequations.domain.model.MathEquation

interface IEquationFormatter {
    fun format(equationItem: MathEquation) : String
}