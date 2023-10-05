import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

//added these two for antd
import Antd from "ant-design-vue";
// import "ant-design-vue/dist/antd.css";

const app = createApp(App)

app.use(createPinia())
app.use(router)

//First is working, but 2nd seems to be too
// app.mount('#app')
app.use(Antd).mount("#app");