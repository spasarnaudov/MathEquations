package com.mathequations.presentation.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mathequations.R
import com.mathequations.presentation.math_equation_list.MathEquationsViewModel
import com.mathequations.domain.equations.formats.EquationItemFormatter
import com.mathequations.presentation.math_equation_list.MathEquationsEvent
import com.mathequations.presentation.math_equation_list.components.EquationItemsList
import com.mathequations.presentation.math_equation_list.components.FilterCheckList
import com.mathequations.presentation.math_equation_list.components.IntervalPicker
import com.mathequations.presentation.math_equation_list.components.OperationPicker
import com.mathequations.ui.theme.MathEquationsTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MathEquationsViewModel>()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MathEquationsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val scaffoldState = rememberBottomSheetScaffoldState()
                    val coroutineScope = rememberCoroutineScope()
                    BottomSheetScaffold(
                        scaffoldState = scaffoldState,
                        sheetContent = {
                            BottomSheetContent()
                        },
                        sheetPeekHeight = 0.dp,
                    ) {
                        Scaffold(
                            floatingActionButton = {
                                FloatingActionButton(
                                    onClick = {
                                        coroutineScope.launch {
                                            scaffoldState.bottomSheetState.expand()
                                        }
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.Settings,
                                        contentDescription = ""
                                    )
                                }
                            },
                        ) {
                            MainContent()
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun MainContent() {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                text = getString(
                    R.string.count_items,
                    "${viewModel.state.value.mathEquations.size}"
                ),
                textAlign = TextAlign.End,
            )
            EquationItemsList(
                EquationItemFormatter()
            )
        }
    }

    @Composable
    fun BottomSheetContent() {
        FilterCheckList(
            filters = viewModel.state.value.mathOperation.filters,
            selectedFilters = viewModel.state.value.filters,
        ) { viewModel.onEvent(MathEquationsEvent.SelectFilter(it)) }
        OperationPicker()
        IntervalPicker()
    }
}