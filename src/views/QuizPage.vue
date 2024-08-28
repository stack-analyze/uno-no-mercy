<script setup lang="ts">
import { computed, ref } from 'vue'

import {
  IonPage, IonContent, IonButton, IonCard, IonItem,
  IonCardHeader, IonCardContent, IonCardTitle,
  IonLabel
} from '@ionic/vue'

import { questions } from '@/scripts/quiz'

// states
const score = ref(0)
const currentQuestion = ref(0)
const anw = ref('')

// computed
const rangeTitle = computed(() => {
  if (score.value >= 0 && score.value <= 3) return 'Inculto'
  if (score.value >= 4 && score.value <= 6) return 'Regular'
  else return 'Conocedor'
})

// method
const compareAnwser = (opt: string) => {
  if (opt === questions[currentQuestion.value].answer) {
    anw.value = `Correcto es: ${questions[currentQuestion.value].answer}`
    score.value++
  } else {
    anw.value = `Incorrecto es: ${questions[currentQuestion.value].answer}`
    score.value += 0
  }
}

const nextQuestion = () => {
  currentQuestion.value++
  anw.value = ''
}

const resetQuiz = () => {
  currentQuestion.value = 0
  score.value = 0
}
</script>

<template>
  <ion-page>
    <ion-content>
      <ion-card class="card" v-if="currentQuestion !== 10">
        <ion-card-header>
          <ion-card-title>
            {{ currentQuestion + 1 }}&#41; {{ questions[currentQuestion].question }}
          </ion-card-title>
        </ion-card-header>

        <ion-card-content>
          <ion-button class="btn btn-anwser" color="secondary" expand="block" fill="outline"
            v-for="opt in questions[currentQuestion].options" :disabled="anw !== ''" @click="compareAnwser(opt)">
            {{ opt }}
          </ion-button>

          <ion-item class="ion-text-center" lines="none">
            <ion-label>{{ anw }}</ion-label>
          </ion-item>

          <ion-button class="btn" color="success" expand="block" fill="outline" :disabled="!anw" @click="nextQuestion">
            Siguiente Pregunta
          </ion-button>
        </ion-card-content>
      </ion-card>

      <ion-card v-else>
        <ion-card-header>
          <ion-card-title>
            felicidades por completar el quiz
          </ion-card-title>
        </ion-card-header>

        <ion-card-content>
          <ion-item>
            <ion-label slot="start">{{ score }} / {{ questions.length }}</ion-label>
            <ion-label slot="end">eres {{ rangeTitle }}</ion-label>
          </ion-item>

          <ion-button class="btn" fill="outline" expand="block" color="success" @click="resetQuiz">
            resetear Quiz
          </ion-button>
        </ion-card-content>
      </ion-card>
    </ion-content>
  </ion-page>
</template>