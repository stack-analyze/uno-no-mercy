import '@ionic/vue/css/ionic.bundle.css'
import '@ionic/vue/css/palettes/dark.always.css'
import './assets/main.css'

import { createApp } from 'vue'
import { IonicVue } from '@ionic/vue';
import App from './App.vue'
import router from './router'

createApp(App)
  .use(IonicVue, { mode: 'md' })
  .use(router)
  .mount('#app')
