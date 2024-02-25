package com.mathequations.presentation.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mathequations.R
import com.mathequations.presentation.math_equation_list.MathEquationsViewModel
import com.mathequations.domain.equations.formats.EquationItemFormatter
import com.mathequations.presentation.math_equation_list.components.EquationItemsList
import com.mathequations.presentation.math_equation_list.components.MathOperationPicker
import com.mathequations.ui.theme.MathEquationsTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MathEquationsViewModel>()
    private var showBottomSheet by mutableStateOf(false)

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

                    val sheetState = rememberModalBottomSheetState()
                    val scope = rememberCoroutineScope()

                    Scaffold(
                        floatingActionButton = {
                            FloatingActionButton(
                                onClick = {
                                    showBottomSheet = true
                                }
                            ) {
                                Icon(Icons.Filled.Add, contentDescription = "")
                            }
                        }
                    ) {
                        Column {
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
                                sheetState = sheetState,
                            ) {
                                MathOperationPicker()
                            }
                        }
                    }
                }
            }
        }
    }
}