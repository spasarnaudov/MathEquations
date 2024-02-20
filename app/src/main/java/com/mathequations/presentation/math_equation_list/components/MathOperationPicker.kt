package com.mathequations.presentation.math_equation_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mathequations.presentation.math_equation_list.MathEquationsViewModel
import com.core.presentation.components.CheckboxList
import com.mathequations.domain.util.MathEquationsEvent

@Composable
fun MathOperationPicker(
    viewModel: MathEquationsViewModel,
    onEquationsGenerate: () -> Unit
) {
    Column(
        modifier = Modifier
            .wrapContentSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SingleChoiceSegmentedButton(
            items = viewModel.getMathOperationsTitles(),
            selectedItem = viewModel.state.value.mathOperation.sign
        ) { viewModel.onEvent(MathEquationsEvent.SelectMathOperation(it)) }

        CheckboxList(
            items = viewModel.state.value.mathOperation.filters.map { it.name },
            onSelectItem = { viewModel.onEvent(MathEquationsEvent.SelectMathFilter(it)) }
        )
        
        Spacer(modifier = Modifier.fillMaxWidth().height(24.dp))
    }
}