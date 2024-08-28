package com.unonomercy.core.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unonomercy.core.ui.scripts.questions

@Composable
fun QuizScreen() {
    // styles
    val questionStyles = Modifier
        .padding(horizontal = 12.dp)
        .offset(y = 12.dp)
    val containerStyles = Modifier
        .fillMaxSize()
        .padding(top = 12.dp)
    val btnStyles = Modifier
        .fillMaxWidth()
        .padding(horizontal = 12.dp, vertical = 10.dp)
    val spacerStyles = Modifier.padding(8.dp)

    // states
    var position by rememberSaveable { mutableIntStateOf(0) }
    var answer by rememberSaveable { mutableStateOf("") }
    var score by rememberSaveable { mutableIntStateOf(0) }
    var btnDisabled by rememberSaveable { mutableStateOf(true) }

    // dynamic
    val rangeTitle = when (score) {
        in 0..3 -> "Inculto"
        in 4..6 -> "Regular"
        else -> "Conocedor"
    }

    val question = position + 1
    val btnEnabled = answer.isNotEmpty()

    // methods
    val compareQuestion = { opt: String ->
        if (opt == questions[position].answer) {
            answer = "Correcto es: ${questions[position].answer}"
            score++
        } else {
            answer = "Incorrecto es ${questions[position].answer}"
            score += 0
        }

        btnDisabled = !btnDisabled
    }

    val nextQuestion = {
        position++
        answer = ""
        btnDisabled = !btnDisabled
    }

    val resetQuiz = {
        position = 0
        score = 0
    }

    // ui
    if (position != 10) Column(
        modifier = containerStyles,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "$question) ${questions[position].question}",
            modifier = questionStyles
        )

        Spacer(modifier = spacerStyles)

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.offset(y = 12.dp)
        ) {
            questions[position].options.forEach {


                OutlinedButton(
                    onClick = { compareQuestion(it) },
                    modifier = btnStyles,
                    enabled = btnDisabled
                ) {
                    Text(text = it, fontSize = 18.sp)
                }
            }

            Text(
                text = answer,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = spacerStyles)

        OutlinedButton(
            onClick = { nextQuestion() },
            modifier = btnStyles,
            enabled = btnEnabled
        ) {
            Text(text = "Siguiente", fontSize = 18.sp)
        }
    } else Column(
        modifier = containerStyles,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "felicidades por completar el quiz",
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "$score / ${questions.size}",
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "\"$rangeTitle\"",
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = spacerStyles)

        OutlinedButton(onClick = { resetQuiz() }, modifier = btnStyles) {
            Text(text = "resetear", fontSize = 25.sp)
        }
    }
}