package com.mathequations.data.remote.dto

import com.mathequations.domain.model.MathEquation

interface MathEquationsApi {
    fun getMathEquations(): List<MathEquation>
//    fun getMathEquation(): MathEquation
}