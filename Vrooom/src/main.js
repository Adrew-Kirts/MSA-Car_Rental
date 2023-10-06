import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

const pinia = createPinia();

import App from './App.vue'
import router from './router'
// import de Ant
import Antd from "ant-design-vue";
import "ant-design-vue/dist/reset.css";

const app = createApp(App)

app.use(router)
app.use(pinia)
// register Ant globally
app.use(Antd).mount("#app");
