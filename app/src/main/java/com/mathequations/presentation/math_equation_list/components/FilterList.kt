package com.mathequations.presentation.math_equation_list.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mathequations.domain.filters.AbstractEquationFilter

@Composable
fun FilterCheckList(
    filters: List<AbstractEquationFilter>,
    selectedFilters: List<AbstractEquationFilter>,
    onFilterSelected: (List<AbstractEquationFilter>) -> Unit
) {
    LazyColumn {
        items(filters) { filter ->
            FilterItem(filter, filter in selectedFilters) { selected ->
                val mutableList: MutableList<AbstractEquationFilter> = selectedFilters.toMutableList()
                if (selected) {
                    mutableList.add(filter)
                } else {
                    mutableList.remove(filter)
                }
                onFilterSelected(mutableList)
            }
        }
    }
}

@Composable
fun FilterItem(
    filter: AbstractEquationFilter,
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
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = filter.name,
            modifier = Modifier
                .weight(1f)
        )
        Checkbox(
            checked = isSelected,
            onCheckedChange = null
        )
    }
}