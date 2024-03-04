package com.core.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.core.Constants

val checkboxStates = mutableStateMapOf<String, Boolean>().withDefault { false }

@Composable
fun CheckboxList(
    items: List<String>,
    onSelectItem: (map:  MutableMap<String, Boolean>) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        items.forEach { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .toggleable(
                        value = checkboxStates.getValue(item)
                    ) {
                        checkboxStates[item] = it
                        onSelectItem.invoke(checkboxStates)
                    }
                    .padding(Constants.Padding.MEDIUM),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item,
                    modifier = Modifier.weight(1f)
                )
                Checkbox(
                    checked = checkboxStates.getValue(item),
                    onCheckedChange = null
                )
            }
        }
    }
}