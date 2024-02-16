package com.mathequations.data.repository

import com.mathequations.data.remote.dto.MathEquationsApi
import com.mathequations.domain.repository.IMathEquationRepository
import com.mathequations.domain.equations.operations.MathOperation
import com.mathequations.domain.filters.IEquationFilter
import com.mathequations.domain.model.MathEquation
import com.mathequations.domain.model.NumbersInterval

class MathEquationsGeneratorRepositoryImpl (
    private val api: MathEquationsApi
): IMathEquationRepository {

    override fun getMathEquations(): List<MathEquation> {
        return api.getMathEquations()
    }
}