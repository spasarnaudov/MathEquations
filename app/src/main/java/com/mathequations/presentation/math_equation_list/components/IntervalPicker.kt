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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.core.Constants
import com.core.presentation.components.DropDownMenu
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
            .padding(bottom = Constants.Dimens.largePadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
        ) {
            IntervalDropdown(
                title = stringResource(R.string.start),
                defaultValue = viewModel.state.value.negativeInterval.toString(),
            ) {
                viewModel.onEvent(MathEquationsEvent.SelectNegativeInterval(it.toInt()))
            }
            IntervalDropdown(
                title = stringResource(R.string.end),
                defaultValue = viewModel.state.value.positiveInterval.toString(),
            ) {
                viewModel.onEvent(MathEquationsEvent.SelectPositiveInterval(it.toInt()))
            }
        }
    }
}

@Composable
fun IntervalDropdown(
    title: String,
    defaultValue: String = "",
    onClick: (String) -> Unit
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
        title = title,
        list = interval,
        defaultValue = defaultValue,
        modifier = Modifier
            .padding(horizontal = Constants.Dimens.smallPadding)
            .width(150.dp),
        onClick = onClick
    )
}