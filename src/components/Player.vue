<script setup lang="ts">
import { ref, computed, watchEffect } from 'vue'

import {
  IonItem, IonButtons, IonButton, IonIcon, IonText,
  alertController, IonToast
} from '@ionic/vue'
import {
  addOutline, arrowUpOutline, refreshOutline, removeOutline,
  arrowDownOutline
} from 'ionicons/icons'

// props
const { player } = defineProps<{
  player: number
}>()

// state
const cards = ref(7)
const isOpen = ref(false)
const ToastColor = ref('')
const ToastConditionMsg = ref('')

// computed
const cardsRange = computed(
  () => cards.value >= 1 && cards.value <= 24
)
const setOpen = (state: boolean) => {
  isOpen.value = state
}

// alert options
const addCards = async () => {
  const alert = await alertController.create({
    header: 'cuantas cartas va a agregar',
    inputs: [
      {
        name: 'cards',
        type: 'number',
        min: 1
      }
    ],
    buttons: [
      {
        text: 'OK',
        handler(data) {
          cards.value += Number(data.cards)
        }
      }
    ]
  })

  await alert.present()
}
const removeCards = async () => {
  const alert = await alertController.create({
    header: 'cuantas cartas va a quitar',
    inputs: [
      {
        name: 'cards',
        type: 'number',
        min: 1
      }
    ],
    buttons: [
      {
        text: 'OK',
        handler(data) {
          cards.value -= Number(data.cards)
        }
      }
    ]
  })

  await alert.present()
}

watchEffect(() => {
  if(cards.value === 0) {
    setOpen(true)
    ToastColor.value = 'success'
    ToastConditionMsg.value = `jugador ${player} ganaste`
  }
  
  if(cards.value >= 25) {
    setOpen(true)
    ToastColor.value = 'danger'
    ToastConditionMsg.value = `jugador ${player} estas eliminado`
  }
})
</script>

<template>
  <ion-item>
    <ion-buttons slot="start">
      <ion-button 
        fill="clear" 
        color="success" 
        :disabled="!cardsRange"
        @click="cards--" 
      >
        <ion-icon :icon="removeOutline" />
      </ion-button>
      <ion-button 
        fill="clear" 
        color="success" 
        :disabled="!cardsRange"
        @click="removeCards"
      >
        <ion-icon :icon="arrowDownOutline" />
      </ion-button>
    </ion-buttons>

    <ion-text>
      jugador {{ player }}: {{ cards }} carta{{ cards !== 1 ? 's' : '' }}
    </ion-text>

    <ion-buttons slot="end">
      <ion-button 
        fill="clear" 
        color="danger" 
        :disabled="!cardsRange"
        @click="cards++" 
      >
        <ion-icon :icon="addOutline" />
      </ion-button>
      <ion-button 
        fill="clear" 
        color="danger" 
        :disabled="!cardsRange"
        @click="addCards"
      >
        <ion-icon :icon="arrowUpOutline" />
      </ion-button>
      <ion-button 
        fill="clear" 
        color="secondary" 
        :disabled="cardsRange"
        @click="cards = 7" 
      >
        <ion-icon :icon="refreshOutline" />
      </ion-button>
    </ion-buttons>
  </ion-item>

  <ion-toast 
    :is-open="isOpen"
    :message="ToastConditionMsg"
    :color="ToastColor"
    :duration="5000"
    @didDismiss="setOpen(false)"
  />
</template>