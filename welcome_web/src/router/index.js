import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/', redirect: '/index'},
    { path: '/index', component: () => import('@/views/index/indexPage.vue')},
    { path: '/about',
      component: () => import('@/views/about/aboutPage.vue')
    },
    { path: '/employment', component: () => import('@/views/employment/employmentPage.vue') },
    { path: '/join', component: () => import('@/views/join/joinPage.vue') }
  ]
})

export default router
