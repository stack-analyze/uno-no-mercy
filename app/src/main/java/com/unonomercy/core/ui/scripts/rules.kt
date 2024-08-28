package com.unonomercy.core.ui.scripts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.unonomercy.core.R.drawable

data class Rule(
    val title: String,
    val desc: String,
    val leadingContent: (@Composable () -> Unit)? = null,
)

val cardStyle = Modifier.size(80.dp)

val rules = listOf(
    Rule(
        "decir uno",
        "cuando tiras tu penultima carta debes decir uno antes que te descubra o de lo contrario debes tomar dos cartas de la pila para tomar."
    ),
    Rule(
        "piedad",
        "esta regla funciona bajo una condición si el jugador tiene una cantidad igual o superior a 25 pierdas la partida."
    ),
    Rule(
        "apilar",
        """
            en esta uno si esta permitda la regla de apilamiento solo se aplicar siempre y cuando sea igual o mayor a la carta que se tiro por ejemplo si la carta que tiro es un toma 2 debes se un toma 2 o superior en caso que tiro un toma 4 o reversa toma 4 no puedes tirar un toma 2.
            En caso que no tiene cartas para responder debes tomar el total de las cartas sumadas.
        """.trimIndent()
    ),
    Rule(
        "como ganar",
        """
            en este uno tienes dos formas de ganar:
                1. te desaches de todas sus cartas
                2. eliminas a todos bajo la regla de piedad.
        """.trimIndent()
    ),
    Rule(
        "Paso de mano con 0",
        "Cuando juegue una carta 0 de cualquier color, TODOS los jugadores deben pasarle sus cartas al siguiente jugador en la dirección actual del juego."
    ) { Image(painterResource(drawable.carta0), "carta 0", cardStyle) },
    Rule(
        "intercambio con 7",
        "Cuando juegue una carta 7 de cualquier color, DEBES intercambiar tus cartas con el otro jugador de tu elección. El juego continua en el orden actual."
    ) { Image(painterResource(drawable.carta7), "carta 7", cardStyle) },
    Rule(
        "toma 2",
        """
           El siguiente jugador en el orden actual tiene que tomar dos cartas y pierde su turno.
           (al menos si tenes para apilar)
       """.trimIndent()
    ) { Image(painterResource(drawable.toma2), "toma 2", cardStyle) },
    Rule(
        "toma 4",
        """
            El siguiente jugador en el orden actual tiene que tomar cuatro cartas y pierde su turno.
            (al menos si tenes para apilar)
        """.trimIndent()
    ) { Image(painterResource(drawable.toma4), "toma 4", cardStyle) },
    Rule(
        "salta",
        "cuando se juega esta carta el siguente jugador en la orden acutal pierde su turno."
    ) { Image(painterResource(drawable.salta), "carta salta", cardStyle) },
    Rule(
        "salta a todos",
        "salta a todos los jugadores y pierde y consigue un turno mas.",
    ) { Image(painterResource(drawable.salta_todos), "carta salta todos", cardStyle) },
    Rule(
        "reversa",
        """
        cuando se juega esta se cumple bajo dos condiciones:
            condición 1: si estas en una partida de ods jugadores actua como una carta salta y te permite otro turno. 
            condición 2: cambia la dirección del juego si el juego iba hacia la derecha el juego ira hacia la izquierda o viceversa.
        """.trimIndent()
    ) { Image(painterResource(drawable.reversa), "carta reversa", cardStyle) },
    Rule(
        "tira un color",
        """
            desecha todas las cartas de tu mano con el color que coincidan con el color de la carta tira un color. 
            Coloca las cartas que deseches debajo de la carta tira un color.
        """.trimIndent()
    ) { Image(painterResource(drawable.tira_un_color), "carta tira un color", cardStyle) },
    Rule(
        "reversa toma 4",
        """
            invierte el sentido de juego, el siguiente jugador en la nueva dirección debe tomar 4 cartas y pierde su turno. 
            Si solo hay dos jugadores, esta carta salta al otro jugador y hace que tu tomes 4 cartas. 
            Puedes utilizar la regla de apilamiento para enviar la sanción de vuelta al otro jugador.
        """.trimIndent()
    ) { Image(painterResource(drawable.reversa_toma4), "carta comodin reversa toma 4", cardStyle) },
    Rule(
        "toma 6",
        "el siguiente jugador tiene que tomar 6 cartas y pierde su turno. Puedes utilizar la regla de apilamiento para enviar la sanción de vuelta al otro jugador."
    ) { Image(painterResource(drawable.toma6), "carta comodin toma 6", cardStyle) },
    Rule(
        "toma 10",
        "el siguiente jugador tiene que tomar 10 cartas y pierde su turno. Puedes utilizar la regla de apilamiento para enviar la sanción de vuelta al otro jugador."
    ) { Image(painterResource(drawable.toma10), "carta comodin toma 10", cardStyle) },
    Rule(
        "ruleta de color",
        "el siguiente jugador elige un color. Después, debe dar la vuelta cartas del mazo de una en una de la pila para tomar hasta que consigue una carta de ese color (los comodines no cuenta). Luego, debe tomar todas las cartas dadas vuelta y pierde su turno."
    ) { Image(painterResource(drawable.ruleta_de_color), "carta comodin ruleta de color", cardStyle) },
    Rule(
        "espejo",
        "el jugador descartas todas las cartas que tenga el mismo valor. Esa regla es innecesaria a favor de la carta tira un color y salta a todos."
    ),
    Rule(
        "no ganar con cartas de acción u comodin",
        "esa regla es usada en un porcentaje bajo a nivel global se trata de prohibir la victoria por medio de cartas de acción o comodin. Es una reglas mas innecesarias debido que este uno es demasido belico para ese tipo de reglas ya que la regla 7-0 es especial."
    ),
    Rule(
        "intercesión",
        "esta regla es opcional le roba el turno a otro jugador siempre y cuando sea una carta identica"
    ),
)
