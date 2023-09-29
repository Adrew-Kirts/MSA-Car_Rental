import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Vehicle from "@/components/Vehicle.vue";
import VehicleList from "@/views/VehicleList.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/vehicles',
      name: 'VehicleList',
      component: VehicleList
    }
  ]
})

export default router
