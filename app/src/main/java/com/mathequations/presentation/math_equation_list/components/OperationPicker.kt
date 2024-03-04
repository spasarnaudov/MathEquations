package com.mathequations.presentation.math_equation_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.core.Constants
import com.core.presentation.components.SingleChoiceSegmentedButton
import com.core.presentation.model.SegmentedButtonItem
import com.mathequations.domain.equations.operations.MathOperation
import com.mathequations.presentation.math_equation_list.MathEquationsEvent
import com.mathequations.presentation.math_equation_list.MathEquationsViewModel

@Composable
fun OperationPicker(
    viewModel: MathEquationsViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Constants.Padding.SMALL),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val items: List<SegmentedButtonItem<MathOperation>> = viewModel.getMathOperations()
        SingleChoiceSegmentedButton(
            items = items,
            selectedItem = items[0]
        ) { viewModel.onEvent(MathEquationsEvent.SelectOperation(it)) }
    }
}