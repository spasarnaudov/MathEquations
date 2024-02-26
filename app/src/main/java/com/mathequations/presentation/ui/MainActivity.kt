package com.mathequations.presentation.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mathequations.R
import com.mathequations.presentation.math_equation_list.MathEquationsViewModel
import com.mathequations.domain.equations.formats.EquationItemFormatter
import com.core.presentation.model.fab.FabItem
import com.mathequations.presentation.math_equation_list.MathEquationsEvent
import com.mathequations.presentation.math_equation_list.components.EquationItemsList
import com.core.presentation.components.fab.ExpandableFab
import com.mathequations.presentation.math_equation_list.components.FilterCheckList
import com.mathequations.presentation.math_equation_list.components.IntervalPicker
import com.mathequations.presentation.math_equation_list.components.OperationPicker
import com.mathequations.ui.theme.MathEquationsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MathEquationsViewModel>()
    private var showBottomSheet by mutableStateOf(false)

    enum class Fab(val value: Int) {
        INTERVAL(2),
        FILTERS(1),
        OPERATIONS(0),
        NONE(-1),
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MathEquationsTheme {
                val (expanded, setExpanded) = remember { mutableStateOf(false) }
                var fabId by remember { mutableIntStateOf(Fab.NONE.value) }
                Surface(
                    modifier = Modifier.fillMaxSize()
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onPress = {
                                    // Collapse FABs when pressing outside
                                    setExpanded(false)
                                }
                            )
                        },
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        floatingActionButton = {
                            ExpandableFab(
                                fabItems = listOf(
                                    FabItem(id = Fab.INTERVAL.value, text = getString(R.string.interval)),
                                    FabItem(id = Fab.FILTERS.value, text = getString(R.string.filters)),
                                    FabItem(id = Fab.OPERATIONS.value, text = getString(R.string.operations)),
                                ),
                                expanded = expanded,
                                setExpanded = setExpanded,
                                onFABClick = {
                                    fabId = it
                                    showBottomSheet = true
                                }
                            )
                        },
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize()
                                .pointerInput(Unit) {
                                    detectTapGestures(
                                        onPress = {
                                            // Collapse FABs when pressing outside
                                            setExpanded(false)
                                        }
                                    )
                                },
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
                        if (showBottomSheet) {
                            ModalBottomSheet(
                                onDismissRequest = {
                                    showBottomSheet = false
                                },
                            ) {
                                when (fabId) {
                                    Fab.INTERVAL.value -> { IntervalPicker() }
                                    Fab.FILTERS.value -> {
                                        FilterCheckList(
                                            filters = viewModel.state.value.mathOperation.filters,
                                            selectedFilters = viewModel.state.value.filters,
                                        ) { viewModel.onEvent(MathEquationsEvent.SelectFilter(it)) }
                                    }
                                    Fab.OPERATIONS.value -> { OperationPicker() }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}