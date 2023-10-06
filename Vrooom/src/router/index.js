import { createRouter, createWebHistory } from 'vue-router'
import About from "@/views/About.vue";
import Signup from "@/views/Signup.vue"
import HomeView from '../views/HomeView.vue'
import VehicleList from "@/views/VehicleList.vue";
import VehicleReservation from "@/views/VehicleReservation.vue";


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path:'/vehicles',
      name: 'vehicleList',
      component: VehicleList
    },
    {
      path: '/vehicle',
      name: 'vehicleReservation',
      component: VehicleReservation
    },
    {
      path: '/about',
      name: 'About',
      component: About
    },
    {
      path: '/signup',
      name: 'User Registration',
      component: Signup
    },
    // {
    //   path:'/vehicles/available',
    //   name:'available',
    //   component:VehicleList
    // }
    {
      path:'/reservation',
      name: 'Add Reservation',
      component:VehicleReservation
    }
  ]
})

export default router
