package com.mathequations.domain.use_case

import com.core.Resource
import com.mathequations.domain.equations.operations.MathOperation
import com.mathequations.domain.filters.AbstractEquationFilter
import com.mathequations.domain.model.MathEquation
import com.mathequations.domain.model.NumbersInterval
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GenerateMathEquationsUseCase {

    operator fun invoke(
        firstNumbersInterval: NumbersInterval,
        secondNumbersInterval: NumbersInterval,
        mathOperations: List<MathOperation>,
        equationFilters: List<AbstractEquationFilter>? = null
    ): Flow<Resource<List<MathEquation>>> = flow {
        val equations: ArrayList<MathEquation> = ArrayList()
        val skipFilters = equationFilters.isNullOrEmpty()
        mathOperations.forEach { mathOperation ->
            for (firstNumber in firstNumbersInterval.start..firstNumbersInterval.end step firstNumbersInterval.step) {
                for (secondNumber in secondNumbersInterval.start..secondNumbersInterval.end step secondNumbersInterval.step) {
                    if (!mathOperation.isValidOperation(firstNumber, secondNumber)) {
                        continue
                    }
                    if (skipFilters || isFilterFound(equationFilters, firstNumber, secondNumber)) {
                        val equation = MathEquation(mathOperation, firstNumber, secondNumber)
                        equations.add(equation)
                    }
                }
            }
        }
        emit(Resource.Success(equations))
    }

    private fun isFilterFound(equationFilters: List<AbstractEquationFilter>?, firstNumber: Int, secondNumber: Int) : Boolean {
        if (equationFilters?.isEmpty() == false) {
            for (equationFilter in equationFilters) {
                if (equationFilter.filter(firstNumber, secondNumber)) {
                    return true
                }
            }
        }
        return false
    }

}