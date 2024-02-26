package com.mathequations.presentation.math_equation_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.Constants
import com.core.Resource
import com.mathequations.domain.equations.operations.AdditionOperation
import com.mathequations.domain.equations.operations.DivisionOperation
import com.mathequations.domain.equations.operations.MathOperation
import com.mathequations.domain.equations.operations.MultiplicationOperation
import com.mathequations.domain.equations.operations.SubtractionOperation
import com.mathequations.domain.model.NumbersInterval
import com.mathequations.domain.model.MathEquationUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MathEquationsViewModel @Inject constructor(
    private val mathEquationUseCases: MathEquationUseCases
): ViewModel() {
    private val _state = mutableStateOf(MathEquationsListState())
    val state: State<MathEquationsListState> = _state

    init {
        generateMathEquations()
    }

    fun onEvent(event: MathEquationsEvent) {
        when(event) {
            is MathEquationsEvent.SelectOperation -> {
                _state.value = MathEquationsListState(mathOperation = mathOperationFromString(event.operation))
                generateMathEquations()
            }
            is MathEquationsEvent.GenerateMathOperation -> {
                generateMathEquations()
            }
            is MathEquationsEvent.SelectFilter -> {
                _state.value = MathEquationsListState(
                    mathOperation = state.value.mathOperation,
                    filters = event.filters
                )
                generateMathEquations()
            }
            is MathEquationsEvent.SelectInterval -> {

            }
        }
    }

    private fun generateMathEquations() {
        val start = -20
        val end = 20
        val interval = NumbersInterval(start, end)
        mathEquationUseCases.generateMathEquationsUseCase(
            interval,
            interval,
            listOf(state.value.mathOperation),
            _state.value.filters
        ).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = MathEquationsListState(
                        mathOperation = state.value.mathOperation,
                        filters = state.value.filters,
                        mathEquations = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = MathEquationsListState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = MathEquationsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getMathOperationsTitles(): List<String> {
        return mathEquationUseCases.getMathOperationsUseCase().map { it.sign }
    }
}

fun mathOperationFromString(sign: String): MathOperation {
    return when(sign) {
        Constants.SIGN_ADDITION -> AdditionOperation()
        Constants.SIGN_SUBTRACTION -> SubtractionOperation()
        Constants.SIGN_MULTIPLICATION -> MultiplicationOperation()
        Constants.SIGN_DIVISION -> DivisionOperation()
        else -> AdditionOperation()
    }
}