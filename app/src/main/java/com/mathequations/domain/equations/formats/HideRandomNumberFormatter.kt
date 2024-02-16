package com.mathequations.domain.equations.formats

import com.mathequations.domain.model.MathEquation
import kotlin.random.Random

class HideRandomNumberFormatter : IEquationFormatter {
    override fun format(equationItem: MathEquation) : String {
        return when (Random.nextInt(0, 3)) {
            0 -> {
                HideFirstNumberFormatter().format(equationItem)
            }
            1 -> {
                HideSecondNumberFormatter().format(equationItem)
            }
            else -> {
                HideResultNumberFormatter().format(equationItem)
            }
        }
    }
}