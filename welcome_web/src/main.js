import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
import axios from 'axios'
import Vue3Lottie from 'vue3-lottie'

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(Vue3Lottie,{name:'Vue3Lottie'})
app.config.globalProperties.$http = axios
app.mount('#app')
