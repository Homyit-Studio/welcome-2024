import { createRouter, createWebHistory } from 'vue-router'
import Main from '@/views/Main/AppMain.vue'
import Login from '@/views/Login/AppLogin.vue'
import Employment from '@/views/Employment/AppEmployment.vue'
import Slider from '@/views/Slider/AppSlider.vue'
import New from '@/views/New/AppStudents.vue'

const routes = [
  { path: '/', redirect: '/Login' },
  { path: '/Login', component: Login },
  {
    path: '/Main',
    component: Main,
    children: [
      { path: '', redirect: '' },
      { path: 'Employment', component: Employment },
      { path: 'Slider', component: Slider },
      { path: 'New', component: New }
    ]
  },
  // 其他路由配置
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router