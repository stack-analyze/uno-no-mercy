package com.unonomercy.core.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.window.DialogProperties
import androidx.core.text.isDigitsOnly
import com.unonomercy.core.R.drawable
import com.unonomercy.core.R.color

@Composable
fun Player(position: Int) {
    // static
    val ctx = LocalContext.current
    val btnSize = Modifier.size(45.dp)

    // states
    var cards by rememberSaveable { mutableIntStateOf(7) }
    var drawCards by remember { mutableStateOf("") }
    var modalAdd by remember { mutableStateOf(false) }
    var modalMinus by remember { mutableStateOf(false) }

    val enabled = cards in 1..24

    if(!modalMinus && cards == 0)
        Toast.makeText(ctx, "jugador $position ha ganado", Toast.LENGTH_SHORT).show()

    if(!modalAdd && cards >= 25)
        Toast.makeText(ctx, "jugador $position ha sido eliminado", Toast.LENGTH_SHORT).show()

    // dialogs
    if (modalMinus) AlertDialog(
        onDismissRequest = { modalMinus = true },
        confirmButton = {
            TextButton(
                onClick = {
                    modalMinus = false
                    var quitCards = drawCards.toInt()

                    if(quitCards > cards ) quitCards = cards

                    cards -= quitCards
                    drawCards = ""
                },
                enabled = drawCards.isNotEmpty()
            ) { Text("OK") }
        },
        dismissButton = {
            TextButton(onClick = {
                drawCards = ""
                modalMinus = false
            }) { Text("Cancel")}
        },
        title = { Text("cuantas cartas va quitar") },
        text = {
            TextField(
                value = drawCards,
                onValueChange = { if (it.isDigitsOnly()) drawCards = it },
                visualTransformation = VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
            )
        },
        properties = DialogProperties(
            dismissOnBackPress = true,
        )
    )

    if (modalAdd) AlertDialog(
        onDismissRequest = { modalAdd = true },
        confirmButton = {
            TextButton(
                onClick = {
                    modalAdd = false
                    cards += drawCards.toInt()
                    drawCards = ""
                },
                enabled = drawCards.isNotEmpty()
            ) { Text("OK") }
        },
        dismissButton = {
            TextButton(onClick = {
                drawCards = ""
                modalAdd = false
            }) { Text("Cancel")}
        },
        title = { Text("cuantas cartas va agregar") },
        text = {
            TextField(
                value = drawCards,
                onValueChange = { if (it.isDigitsOnly()) drawCards = it },
                visualTransformation = VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
            )
        },
        properties = DialogProperties(
            dismissOnBackPress = true,
        ),
    )

    // content
    ListItem(
        leadingContent = {
            Row {
                IconButton(
                    { cards-- }, btnSize, enabled,
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = colorResource(id = color.success)
                    ),
                ) {
                    Icon(painterResource(drawable.ic_neg_1), "minus one")
                }
                IconButton(
                    { modalMinus = true }, btnSize, enabled,
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = colorResource(id = color.success)
                    ),
                ) {
                    Icon(
                        painterResource(drawable.ic_double_arrow_down),
                        "minus one"
                    )
                }
            }
        },
        headlineContent = { Text("player $position: $cards") },
        trailingContent = {
            Row {
                IconButton(
                    onClick = { cards++ }, modifier = btnSize, enabled,
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = MaterialTheme.colorScheme.error
                    ),
                ) {
                    Icon(painterResource(drawable.ic_plus_1), "minus one")
                }
                IconButton(
                    { modalAdd = true }, btnSize, enabled,
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = MaterialTheme.colorScheme.error
                    ),
                ) {
                    Icon(
                        painterResource(drawable.ic_double_arrow_up),
                        "minus one"
                    )
                }

                IconButton(
                    { cards = 7 }, btnSize, !enabled,
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = MaterialTheme.colorScheme.secondary
                    )
                ) {
                    Icon(Icons.Outlined.Refresh, contentDescription = "reset")
                }
            }
        },
        modifier = Modifier.clip(RoundedCornerShape(20.dp)),
        colors = ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    )
}
