import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
import Vehicle from "@/components/Vehicle.vue";

const app = createApp(App)

app.use(createPinia())
app.use(router)

app.component('Vehicle', Vehicle);

app.mount('#app')
