<script setup lang="ts">
import {
  IonPage, IonContent, IonItem, IonImg, IonLabel, IonText, IonList, IonThumbnail
} from "@ionic/vue";

import { playCircle, radio, library, search } from 'ionicons/icons';

import { rules } from '@/scripts/rules'
</script>

<template>
  <ion-page>
    <ion-content>
      <ion-list :inset="true">
        <ion-item v-for="rule of rules">
          <ion-thumbnail slot="start" v-show="rule.card">
            <ion-img :src="rule.card" :alt="rule.title" />
          </ion-thumbnail>
          <ion-label position="stacked">{{ rule.title }}</ion-label>
          <ion-text>{{ rule.desc }}</ion-text>
        </ion-item>
      </ion-list>
    </ion-content>
  </ion-page>
</template>