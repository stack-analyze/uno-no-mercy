<script setup lang="ts">
import {
  IonPage, IonContent, IonCard, IonCardHeader, IonCardTitle,
  IonCardSubtitle, IonCardContent, IonGrid, IonRow, IonCol,
  IonImg, IonButton
} from '@ionic/vue';

import { links } from '@/scripts/links'
</script>

<template>
  <ion-page>
    <ion-content>
      <ion-card class="card">
        <ion-card-header >
          <ion-img 
            class="cover-about"
            src="/img/no_mercy.webp" 
            alt="cover" 
          />
        </ion-card-header>
        <ion-card-content class="ion-text-center">
          <ion-card-title>UNO no mercy!</ion-card-title>
          <ion-card-subtitle>
            desarrollado por omega5300
          </ion-card-subtitle>
        </ion-card-content>

        <ion-grid>
          <ion-row class="ion-text-center">
            <ion-col size="6" v-for="({href, name, color}) of links">
              <ion-button fill="clear"
                :href
                :color
                target="_blank"
              >
                {{ name }}
              </ion-button>
            </ion-col>
          </ion-row>
        </ion-grid>
      </ion-card>
    </ion-content>
  </ion-page>
</template>