package com.mathequations.presentation.math_equation_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.Resource
import com.core.presentation.model.SegmentedButtonItem
import com.mathequations.domain.equations.operations.MathOperation
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
                _state.value = state.value.copy(
                    mathOperation = event.operation.item,
                    filters = emptyList(),
                )
                generateMathEquations()
            }
            is MathEquationsEvent.GenerateMathOperation -> {
                generateMathEquations()
            }
            is MathEquationsEvent.SelectFilter -> {
                _state.value = state.value.copy(
                    mathOperation = state.value.mathOperation,
                    filters = event.filters
                )
                generateMathEquations()
            }
            is MathEquationsEvent.SelectNegativeInterval -> {
                _state.value = state.value.copy(
                    interval = event.interval.item
                )
                generateMathEquations()
            }
        }
    }

    private fun generateMathEquations() {
        if(state.value.interval != null) {
            mathEquationUseCases.generateMathEquationsUseCase(
                state.value.interval!!,
                state.value.interval!!,
                listOf(state.value.mathOperation),
                _state.value.filters
            ).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = state.value.copy(
                            mathOperation = state.value.mathOperation,
                            filters = state.value.filters,
                            mathEquations = result.data ?: emptyList()
                        )
                    }

                    is Resource.Error -> {
                        _state.value = MathEquationsListState(
                            error = result.message ?: "An unexpected error occured"
                        )
                    }

                    is Resource.Loading -> {
                        _state.value = MathEquationsListState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

    fun getMathOperations(): List<SegmentedButtonItem<MathOperation>> {
        return mathEquationUseCases.getMathOperationsUseCase()
    }

    fun getIntervals(): List<SegmentedButtonItem<NumbersInterval>> {
        return mathEquationUseCases.getIntervalsUseCase()
    }
}