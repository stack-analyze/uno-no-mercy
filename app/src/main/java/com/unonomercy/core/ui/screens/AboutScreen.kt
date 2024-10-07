package com.unonomercy.core.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unonomercy.core.R.drawable
import com.unonomercy.core.R.string

@Composable
fun AboutScreen() {
    // styles
    val pageStyle = Modifier
        .fillMaxSize()
        .clip(RoundedCornerShape(12.dp))
        .padding(5.dp)
    val cardStyle = Modifier
        .padding(24.dp)
    val imageStyle = Modifier
        .height(150.dp)
        .padding(top = 16.dp)
        .fillMaxWidth()
    val contentPadding = Modifier.padding(16.dp)

    val localUriHandler = LocalUriHandler.current

    Column(
        modifier = pageStyle,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        OutlinedCard(
            modifier = cardStyle,
            colors = CardDefaults.outlinedCardColors(
                contentColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column {
                Image(
                    painterResource(drawable.no_mercy),
                    "no mercy app", imageStyle
                )

                Column(modifier = contentPadding) {
                    Text(
                        stringResource(string.app_name),
                        style = MaterialTheme.typography.titleLarge,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "desarrollado por omega5300 de stack-analyze",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.primary,
                    )
                }

                Row(horizontalArrangement = Arrangement.Absolute.Right) {
                    TextButton(
                        onClick = { localUriHandler.openUri("https://neo-jquery.vercel.app/no_mercy") },
                        colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.secondary)
                    ) { Text("journal", fontSize = 20.sp) }
                    
                    TextButton(
                        onClick = { localUriHandler.openUri("https://www.youtube.com/watch?v=8eL99lY375A") },
                        colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.secondary)
                    ) { Text("origen de quiz", fontSize = 20.sp) }
                }
            }
        }
    }
}
