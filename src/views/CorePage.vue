<script setup lang="ts">
import {
  IonPage, IonTabs, IonRouterOutlet, IonTabBar, IonTabButton, IonLabel, IonIcon
} from "@ionic/vue";

import { 
  bookOutline, swapVerticalOutline, createOutline, personOutline 
} from 'ionicons/icons';

const routes = [
  {
    href: '/rules',
    tab: 'Reglas',
    icon: bookOutline
  },
  {
    href: '/counter',
    tab: 'Contador',
    icon: swapVerticalOutline
  },
  {
    href: '/quiz',
    tab: 'Quiz',
    icon: createOutline
  },
  {
    href: '/about',
    tab: 'Acerca de',
    icon: personOutline
  },
]
</script>

<template>
  <ion-page>
    <ion-tabs>
      <ion-router-outlet></ion-router-outlet>
      <ion-tab-bar slot="bottom">
        <ion-tab-button 
          v-for="route of routes" 
          :tab="route.tab"
          :href="route.href"
        >
          <ion-icon :icon="route.icon" />
          <ion-label>{{ route.tab }}</ion-label>
        </ion-tab-button>
      </ion-tab-bar>
    </ion-tabs>
  </ion-page>
</template>