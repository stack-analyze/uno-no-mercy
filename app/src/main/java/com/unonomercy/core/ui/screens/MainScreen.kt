package com.unonomercy.core.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.unonomercy.core.ui.components.RuleItem
import com.unonomercy.core.ui.scripts.rules

@Composable
fun MainScreen() {
    val mainStyles = Modifier.fillMaxSize().padding(4.dp)
    val state = rememberLazyListState()

    LazyColumn(
        state = state,
        modifier =  mainStyles
    ) {
        items(rules) {
            RuleItem(it.title, it.desc) { it.leadingContent?.invoke() }
        }
    }
}

