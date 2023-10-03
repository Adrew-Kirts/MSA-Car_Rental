import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import VehicleList from "@/views/VehicleList.vue";
import VehicleReservation from '../views/VehicleReservation.vue';
import SignUp from '../views/SignUp.vue'

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
    },
    {
      path: '/reservation',
      name: 'VehicleReservation',
      component: VehicleReservation
    },
    {
      path: '/signup',
      name: 'Signup',
      component: SignUp
    }
  ]
})

export default router
