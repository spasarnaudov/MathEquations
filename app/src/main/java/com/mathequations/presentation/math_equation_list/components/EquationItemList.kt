package com.mathequations.presentation.math_equation_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.core.Constants
import com.mathequations.presentation.math_equation_list.MathEquationsViewModel
import com.mathequations.domain.equations.formats.IEquationFormatter

@Composable
fun EquationItemsList(
    equationFormatter: IEquationFormatter,
    viewModel: MathEquationsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = Constants.Dimens.smallPadding)) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(state.mathEquations) { i, mathEquation ->
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable { }
                        .padding(Constants.Dimens.smallPadding)
                ) {
                    Text(
                        text = "${i + 1}.",
                        modifier = Modifier
                            .padding(horizontal = Constants.Dimens.smallPadding),
                    )
                    Text(
                        text = equationFormatter.format(mathEquation),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = Constants.Dimens.smallPadding),
                    )
                }

            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Constants.Dimens.smallPadding)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}