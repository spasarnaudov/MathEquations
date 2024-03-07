package com.core.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import kotlin.math.roundToInt

@Composable
fun SeekBarWithPositions(
    items: List<String>,
    selectedItem: String,
    title: ((String) -> String)? = null,
    onSelectItem: (String) -> Unit
) {
    var sliderPosition by remember { mutableFloatStateOf(1f * items.indexOf(selectedItem)) }

    val selectedLabel = if (sliderPosition.roundToInt() != -1) items[sliderPosition.roundToInt()] else ""

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        title?.let { Text(text = it.invoke(selectedLabel)) }

        Slider(
            value = sliderPosition,
            onValueChange = {
                sliderPosition = it
            },
            valueRange = 0f..1f * (items.size - 1),
            steps = items.size - 2,
            onValueChangeFinished = {
                onSelectItem(items[sliderPosition.roundToInt()])
            }
        )
    }
}