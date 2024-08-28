interface Question {
    question: string,
    options: string[],
    answer: string,
}

const randomField = () => Math.random() - 0.5

export const questions: Question[] = [
    {
        question: '¿Cuántos paqurtes de cartas contiene el UNO no mercy?',
        options: ['2 paquetes', '3 paquetes', '4 paquetes'].sort(randomField),
        answer: '3 paquetes'
    },
    {
        question: '¿Cuántas cartas repartimos a cada jugador en la fase de preparación?',
        options: ['8 cartas', '10 cartas', '7 cartas'].sort(randomField),
        answer: '7 cartas'
    },
    {
        question: '¿Cuál carta numerada te deja cambiar de mano con cualquier jugador?',
        options: ['carta 0', 'carta 7'].sort(randomField),
        answer: 'carta 7'
    },
    {
        question: '¿Cuál es la carta de acción que incluyeron de uno Flip! a este juego de cartas?',
        options: ['tira un color', 'salta a todos', 'comodín toma 6'].sort(randomField),
        answer: 'salta a todos'
    },
    {
        question: '¿Cuántos comodines hay en UNO no mercy?',
        options: [ '5 comodines', '3 comodines', '4 comodines'].sort(randomField),
        answer: '4 comodines'
    },
    {
        question: '¿Cómo se llama la regla que te expulsa del juego al llegar a 25 cartas o más?',
        options: ['acumulación', 'piedad', 'eliminación'].sort(randomField),
        answer: 'piedad'
    },
    {
        question: '¿Cuántas cartas de (acción/comodines) tiene este juego de cartas?',
        options: ['10', '8', '4'].sort(randomField),
        answer: '10'
    },
    {
        question: '¿La carta toma 4 es un comodín?',
        options: ['cierto', 'falso'].sort(randomField),
        answer: 'falso'
    },
    {
        question: '¿Cuál UNO tiene cartas de doble función así como lo vemos en el comodín reversa y toma 4?',
        options: ['UNO flip!', 'UNO remix', 'UNO flex!'].sort(randomField),
        answer: 'UNO flex!'
    },
    {
        question: '¿Se puede poner una carta +4 encima de un +6 para pasar el castigo?',
        options: ['cierto', 'falso'].sort(randomField),
        answer: 'falso'
    },
]
