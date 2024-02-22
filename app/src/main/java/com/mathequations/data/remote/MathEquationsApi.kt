package com.mathequations.data.remote

import com.mathequations.domain.model.MathEquation

interface MathEquationsApi {
    fun getMathEquations(): List<MathEquation>
}