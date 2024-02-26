package com.mathequations.presentation.math_equation_list.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.core.presentation.components.CheckListItem
import com.mathequations.domain.filters.AbstractEquationFilter

@Composable
fun FilterCheckList(
    filters: List<AbstractEquationFilter>,
    selectedFilters: List<AbstractEquationFilter>,
    onFilterSelected: (List<AbstractEquationFilter>) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        items(filters) { filter ->
            CheckListItem(filter.name, filter in selectedFilters) { selected ->
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