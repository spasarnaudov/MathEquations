package com.mathequations.domain.repository

import com.mathequations.domain.model.MathEquation

interface IMathEquationRepository {
    fun getMathEquations(): List<MathEquation>
}