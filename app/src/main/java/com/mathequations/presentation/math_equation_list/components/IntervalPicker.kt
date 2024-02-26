package com.mathequations.presentation.math_equation_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.core.presentation.components.SingleChoiceSegmentedButton
import com.mathequations.R
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
//                "1000",
            ),
            selectedItem = viewModel.state.value.interval.toString()
        ) { viewModel.onEvent(MathEquationsEvent.SelectInterval(it.toInt())) }

        var isChecked by remember { mutableStateOf(viewModel.state.value.negativeNumbers) }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            // Text label displaying the current state of the switch
            Text(stringResource(R.string.add_negative_numbers))

            // The switch itself
            Switch(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                    viewModel.onEvent(MathEquationsEvent.SelectSwitchNegative(it))
                }
            )
        }
    }
}