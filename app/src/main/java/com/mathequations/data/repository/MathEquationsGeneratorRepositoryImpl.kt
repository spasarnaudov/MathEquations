package com.mathequations.data.repository

import com.mathequations.data.remote.MathEquationsApi
import com.mathequations.domain.repository.IMathEquationRepository
import com.mathequations.domain.model.MathEquation

class MathEquationsGeneratorRepositoryImpl (
    private val api: MathEquationsApi
): IMathEquationRepository {

    override fun getMathEquations(): List<MathEquation> {
        return api.getMathEquations()
    }
}