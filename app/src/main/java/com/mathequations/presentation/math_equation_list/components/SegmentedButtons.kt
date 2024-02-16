package com.mathequations.presentation.math_equation_list.components

import android.annotation.SuppressLint
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import com.mathequations.domain.equations.operations.MathOperation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleChoiceSegmentedButton(
    items: List<String>,
    selectedItem: String = "",
    onSelectItem: (String) -> Unit
) {
    var selectedIndex by remember {
        mutableIntStateOf(items.indexOf(selectedItem))
    }
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
    ) {
        SingleChoiceSegmentedButtonRow {
            items.forEachIndexed { index, item ->
                SegmentedButton(
                    selected = selectedIndex == index,
                    onClick = {
                        selectedIndex = index
                        onSelectItem.invoke(item)
                    },
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = items.size
                    )
                ) {
                    Text(text = item)
                }
            }
        }
    }
}