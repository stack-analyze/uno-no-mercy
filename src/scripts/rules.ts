interface Rule {
  title: string;
  desc: string;
  card?: string;
}

export const rules: Rule[] = [
  {
    title: "decir uno",
    desc: "cuando tiras tu penultima carta debes decir uno antes que te descubra o de lo contrario debes tomar dos cartas de la pila para tomar."
  },
  {
    title: "piedad",
    desc: "esta regla funciona bajo una condición si el jugador tiene una cantidad igual o superior a 25 pierdas la partida."
  },
  {
    title: "apilar",
    desc: `
      en esta uno si esta permitda la regla de apilamiento solo se aplicar siempre y cuando sea igual o mayor a la carta que se tiro por ejemplo si la carta que tiro es un toma 2 debes se un toma 2 o superior en caso que tiro un toma 4 o reversa toma 4 no puedes tirar un toma 2.
            En caso que no tiene cartas para responder debes tomar el total de las cartas sumadas.
    `
  },
  {
    title: "como ganar",
    desc: `
      en este uno tienes dos formas de ganar:
        1. te desaches de todas sus cartas
        2. eliminas a todos bajo la regla de piedad.
    `
  },
  {
    title: "Paso de mano con 0",
    desc: "Cuando juegue una carta 0 de cualquier color, TODOS los jugadores deben pasarle sus cartas al siguiente jugador en la dirección actual del juego.",
    card: "img/carta0.webp"
  },
  {
    title: "intercambio con 7",
    desc: "Cuando juegue una carta 7 de cualquier color, DEBES intercambiar tus cartas con el otro jugador de tu elección. El juego continua en el orden actual.",
    card: "img/carta7.webp"
  },
  {
    title: "toma 2",
    desc: "El siguiente jugador en el orden actual tiene que tomar dos cartas y pierde su turno.",
    card: "img/toma2.webp"
  },
  {
    title: "toma 4",
    desc: "El siguiente jugador en el orden actual tiene que tomar cuatro cartas y pierde su turno.",
    card: "img/toma4.webp"
  },
  {
    title: "salta",
    desc: "cuando se juega esta carta el siguente jugador en la orden acutal pierde su turno.",
    card: "img/salta.webp"
  },
  {
    title: "salta a todos",
    desc: "salta a todos los jugadores y pierde y consigue un turno mas.",
    card: "img/salta_todos.webp"
  },
  {
    title: "reversa",
    desc: `
    cuando se juega esta se cumple bajo dos condiciones:
      condición 1: si estas en una partida de ods jugadores actua como una carta salta y te permite otro turno. 
      condición 2: cambia la dirección del juego si el juego iba hacia la derecha el juego ira hacia la izquierda o viceversa.
    `,
    card: "img/reversa.webp"
  },
  {
    title: "tira un color",
    desc: `
    desecha todas las cartas de tu mano con el color que coincidan con el color de la carta tira un color. 
      Coloca las cartas que deseches debajo de la carta tira un color.
     `,
    card: "img/tira_un_color.webp"
  },
  {
    title: "reversa toma 4",
    desc: `
    invierte el sentido de juego, el siguiente jugador en la nueva dirección debe tomar 4 cartas y pierde su turno. 
      Si solo hay dos jugadores, esta carta salta al otro jugador y hace que tu tomes 4 cartas. 
      Puedes utilizar la regla de apilamiento para enviar la sanción de vuelta al otro jugador.
    `,
    card: "img/reversa_toma4.webp"
  },
  {
    title: "toma 6",
    desc: "el siguiente jugador tiene que tomar 6 cartas y pierde su turno. Puedes utilizar la regla de apilamiento para enviar la sanción de vuelta al otro jugador.",
    card: "img/toma6.webp"
  },
  {
    title: "toma 10",
    desc: "el siguiente jugador tiene que tomar 10 cartas y pierde su turno. Puedes utilizar la regla de apilamiento para enviar la sanción de vuelta al otro jugador.",
    card: "img/toma10.webp"
  },
  {
    title: "ruleta de color",
    desc: `
    el siguiente jugador elige un color. Después, debe dar la vuelta cartas del mazo de una en una de la pila para tomar hasta que consigue una carta de ese color (los comodines no cuenta). Luego, debe tomar todas las cartas dadas vuelta y pierde su turno.
    `,
    card: "img/ruleta_de_color.webp"
  },
  {
    title: "espejo",
    desc: "el jugador descartas todas las cartas que tenga el mismo valor. Esa regla es innecesaria a favor de la carta tira un color y salta a todos.",
  },
  {
    title: "no ganar con cartas de acción u comodin",
    desc: `
    esa regla es usada en un porcentaje bajo a nivel global se trata de prohibir la victoria por medio de cartas de acción o comodin. Es una reglas mas innecesarias debido que este uno es demasido belico para ese tipo de reglas ya que la regla 7-0 es especial.
    `,
  },
  {
    title: "intercesión",
    desc: "esta regla es opcional le roba el turno a otro jugador siempre y cuando sea una carta identica",
  },
];

