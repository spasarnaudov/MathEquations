package com.core.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.core.Constants

@Composable
fun CheckListItem(
    @StringRes text: Int,
    isSelected: Boolean,
    onSelectionChanged: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .toggleable(
                value = isSelected
            ) {
                onSelectionChanged.invoke(it)
            }
            .padding(Constants.Padding.SMALL),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            modifier = Modifier
                .wrapContentSize()
                .padding(end = Constants.Padding.SMALL),
            checked = isSelected,
            onCheckedChange = null
        )
        Text(
            text = stringResource(id = text),
            modifier = Modifier.weight(1f)
        )
    }
}