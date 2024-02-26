package com.mathequations.presentation.math_equation_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.core.presentation.components.SingleChoiceSegmentedButton
import com.mathequations.presentation.math_equation_list.MathEquationsEvent
import com.mathequations.presentation.math_equation_list.MathEquationsViewModel

@Composable
fun IntervalPicker(
    viewModel: MathEquationsViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SingleChoiceSegmentedButton(
            items = listOf(
                "20",
                "100",
                "1000",
            ),
            selectedItem = "20"
        ) { viewModel.onEvent(MathEquationsEvent.SelectInterval(it)) }
    }
}