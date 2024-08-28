package com.unonomercy.core.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.unonomercy.core.ui.components.Player

@Composable
fun CounterView() {
    // static
    val players = listOf(0, 2, 3, 4, 5, 6)

    // states
    var totalPlayers by rememberSaveable { mutableIntStateOf(0) }
    var expanded by remember { mutableStateOf(false) }
    val state = rememberLazyListState()

    val counterStyles = Modifier
        .padding(5.dp)

    // content
    LazyColumn(
        modifier = counterStyles,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        state = state
    ) {
        item {
            ListItem(
                headlineContent = { Text("número de jugadores") },
                trailingContent = {
                    TextButton({ expanded = true }) {
                        Text(totalPlayers.toString(), fontSize = 18.sp)
                        Icon(
                            Icons.Outlined.ArrowDropDown,
                            "select players", Modifier.size(30.dp)
                        )
                    }

                    DropdownMenu(expanded, { expanded = false }) {
                        players.forEach {
                            DropdownMenuItem(
                                { Text(if (it == 0) "Players" else it.toString()) },
                                {
                                    expanded = false
                                    totalPlayers = it
                                }
                            )
                        }
                    }
                })
        }

        if (totalPlayers == 0) item {
            Text(
                "Bienvenidos al modo contador de UNO No mercy!",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(25.dp)
                    .fillMaxSize()
            )
        } else items(totalPlayers) { i ->
            Player(i + 1)
        }
    }

}
