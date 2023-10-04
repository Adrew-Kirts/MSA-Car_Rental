import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
// import de Ant
import Antd from "ant-design-vue";
import "ant-design-vue/dist/antd.css";

const app = createApp(App)

app.use(createPinia())
app.use(router)
// register Ant globally
app.use(Antd).mount("#app");

app.mount('#app')
