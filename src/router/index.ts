import { createRouter, createWebHistory } from '@ionic/vue-router'
import { type RouteRecordRaw } from 'vue-router'

import CorePage from '@/views/CorePage.vue'
import RulesPage from '@/views/RulesPage.vue'
import CounterPage from '@/views/CounterPage.vue'
import QuizPage from '@/views/QuizPage.vue'
import AboutPage from '@/views/AboutPage.vue'

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    redirect: '/rules',
  },
  {
    path: '/',
    component: CorePage,
    children: [
      {
        path: '',
        redirect: '/rules',
      },
      {
        path: 'rules',
        component: RulesPage,
      },
      {
        path: 'counter',
        component: CounterPage,
      },
      {
        path: 'quiz',
        component: QuizPage,
      },
      {
        path: 'about',
        component: AboutPage,
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
