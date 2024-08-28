package com.unonomercy.core.ui.scripts

data class Quiz(
    val question: String,
    val options: List<String>,
    val answer: String,
)

val questions = listOf(
    Quiz(
        "¿Cuántos paqurtes de cartas contiene el UNO no mercy?", listOf(
            "2 paquetes", "3 paquetes", "4 paquetes"
        ).shuffled(), "3 paquetes"
    ),
    Quiz(
        "¿Cuántas cartas repartimos a cada jugador en la fase de preparación?", listOf(
            "8 cartas", "10 cartas", "7 cartas"
        ).shuffled(), "7 cartas"
    ),
    Quiz(
        "¿Cuál carta numerada te deja cambiar de mano con cualquier jugador?", listOf(
            "carta 0", "carta 7"
        ).shuffled(), "carta 7"
    ),
    Quiz(
        "¿Cuál es la carta de acción que incluyeron de uno Flip! a este juego de cartas?", listOf(
            "tira un color", "salta a todos", "comodín +6"
        ).shuffled(), "salta a todos"
    ),
    Quiz(
        "¿Cuántos comodines hay en UNO no mercy?", listOf(
            "5 comodines", "3 comodines", "4 comodines"
        ).shuffled(), "4 comodines"
    ),
    Quiz(
        "¿Cómo se llama la regla que te expulsa del juego al llegar a 25 cartas o más?", listOf(
            "acumulación", "piedad", "eliminación"
        ).shuffled(), "piedad"
    ),
    Quiz(
        "¿Cuántas cartas de (acción/comodines) tiene este juego de cartas?", listOf(
            "10", "8", "4"
        ).shuffled(), "10"
    ),
    Quiz(
        "¿La carta toma 4 es un comodín?", listOf(
            "cierto", "falso"
        ).shuffled(), "falso"
    ),
    Quiz(
        "¿Cuál UNO tiene cartas de doble función así como lo vemos en el comodín reversa y toma 4?",
        listOf(
            "UNO flip!", "UNO remix", "UNO flex!"
        ).shuffled(),
        "UNO flex!"
    ),
    Quiz(
        "¿Se puede poner una carta +4 encima de un +6 para pasar el castigo?", listOf(
            "cierto", "falso"
        ).shuffled(), "falso"
    ),
)
