package com.core.presentation.components.fab

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.core.presentation.model.fab.FabItem

@Composable
fun ExpandableFab(
    fabItems: List<FabItem>,
    expanded: Boolean,
    setExpanded: (Boolean) -> Unit,
    onFABClick: (Int) -> Unit,
) {
//    val (expanded, setExpanded) = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.wrapContentSize()
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        // Collapse FABs when pressing outside
                        setExpanded(false)
                    }
                )
            },
        horizontalAlignment = Alignment.End
    ) {

        // Additional FABs
        AnimatedVisibility(visible = expanded) {
            Column {
                fabItems.forEach { fabItem ->
                    FloatingActionButton(
                        onClick = {
                            setExpanded(false)
                            onFABClick.invoke(fabItem.id)
                        },
                        modifier = Modifier.padding(bottom = 8.dp)
                            .align(Alignment.End)
                    ) {
                        if (fabItem.text.isNotEmpty()) {
                            Text(
                                modifier = Modifier.padding(horizontal = 16.dp),
                                text = fabItem.text
                            )
                        }
                        if (fabItem.icon != null) {
                            Icon(
                                fabItem.icon,
                                contentDescription = fabItem.text
                            )
                        }
                    }
                }
            }
        }

        // Main FAB
        FloatingActionButton(
            onClick = { setExpanded(!expanded) }
        ) {
            Icon(
                if (expanded) Icons.Filled.Close else Icons.Filled.Add,
                contentDescription = ""
            )
        }
    }
}