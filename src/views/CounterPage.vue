<script setup lang="ts">
import { ref } from 'vue'

import {
  IonPage, IonContent, IonSelect, IonSelectOption, 
  IonList, IonItem, IonLabel
} from '@ionic/vue'

import Player from '@/components/Player.vue'

const players = [2, 3, 4, 5, 6];

const totalPlayers = ref(0)
</script>

<template>
  <ion-page>
    <ion-content>
      <ion-item>
        <ion-select 
          justify="space-between" 
          label="num. jugadores" 
          placeholder="elige el total de jugadores"
          v-model="totalPlayers" 
          interface="popover"
        >
          <ion-select-option :value="0">sin jugadores</ion-select-option>
          
          <ion-select-option v-for="player in players" :value="player" slot="end" interface="popover">
            {{ player }}
          </ion-select-option>
        </ion-select>
      </ion-item>

      

      <ion-list :inset="true">
        <ion-item class="ion-text-center" v-if="totalPlayers === 0">
          <ion-label>Bienvenidos</ion-label>
        </ion-item>
        <Player v-else v-for="player in totalPlayers" :player />
      </ion-list>
    </ion-content>
  </ion-page>
</template>