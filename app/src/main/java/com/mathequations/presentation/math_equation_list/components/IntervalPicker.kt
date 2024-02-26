package com.mathequations.presentation.math_equation_list.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.core.presentation.components.DropDownMenu
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
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
        ) {
            val interval = listOf(
                "-300",
                "-100",
                "-20",
                "0",
                "20",
                "100",
                "300",
            )
            DropDownMenu(
                title = "Start",
                list = interval,
                defaultValue = viewModel.state.value.negativeInterval.toString(),
                modifier = Modifier.width(150.dp),
                ) {
                viewModel.onEvent(MathEquationsEvent.SelectNegativeInterval(it.toInt()))
            }
            Spacer(modifier = Modifier.width(10.dp))
            DropDownMenu(
                title = "End",
                list = interval,
                defaultValue = viewModel.state.value.positiveInterval.toString(),
                modifier = Modifier.width(150.dp),
            ) {
                viewModel.onEvent(MathEquationsEvent.SelectPositiveInterval(it.toInt()))
            }
        }
    }
}