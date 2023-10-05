import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import vehicleList from "@/views/vehicleList.vue";
// import {patch} from "axios";
import vehicleReservation from "@/views/vehicleReservation.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (About.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import('../views/AboutView.vue')
    // }
    {
      path:'/vehicles',
      name: 'vehicleList',
      component: vehicleList
    },
    {
      path: '/vehicles/:id',
      name: 'vehicleReservation',
      component: vehicleReservation
    }
  ]
})

export default router
