package com.mathequations.domain.use_case

import com.mathequations.common.Resource
import com.mathequations.domain.equations.operations.MathOperation
import com.mathequations.domain.filters.IEquationFilter
import com.mathequations.domain.repository.IMathEquationRepository
import com.mathequations.domain.model.MathEquation
import com.mathequations.domain.model.NumbersInterval
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GenerateMathEquationsUseCase {

    operator fun invoke(
        firstNumbersInterval: NumbersInterval,
        secondNumbersInterval: NumbersInterval,
        mathOperations: List<MathOperation>,
        equationFilters: List<IEquationFilter>? = null
    ): Flow<Resource<List<MathEquation>>> = flow {
        val equations: ArrayList<MathEquation> = ArrayList()
        mathOperations.forEach { mathOperation ->
            for (firstNumber in firstNumbersInterval.start..firstNumbersInterval.end step firstNumbersInterval.step) {
                for (secondNumber in secondNumbersInterval.start..secondNumbersInterval.end step secondNumbersInterval.step) {
                    if (mathOperation.filter(firstNumber, secondNumber)) {
                        continue
                    }
                    if (filter(equationFilters, firstNumber, secondNumber)) {
                        continue
                    }
                    val equation = MathEquation(mathOperation, firstNumber, secondNumber)
                    equations.add(equation)
                }
            }
        }
        emit(Resource.Success(equations))
    }

    private fun filter(equationFilters: List<IEquationFilter>?, firstNumber: Int, secondNumber: Int) : Boolean {
        if (equationFilters?.isEmpty() == false) {
            for (equationFilter in equationFilters) {
                if (!equationFilter.filter(firstNumber, secondNumber)) {
                    return true
                }
            }
        }
        return false
    }

}