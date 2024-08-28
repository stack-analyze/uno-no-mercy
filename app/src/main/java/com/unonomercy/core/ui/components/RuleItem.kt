package com.unonomercy.core.ui.components

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun RuleItem(title: String, desc: String, leadingContent: (@Composable () -> Unit)? = null) {
    ListItem(
        headlineContent = { Text(title) },
        supportingContent = { Text(desc) },
        leadingContent = leadingContent,
    )
    HorizontalDivider()
}
