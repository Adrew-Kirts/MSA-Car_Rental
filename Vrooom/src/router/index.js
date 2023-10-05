import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import VehicleReservation from "@/views/VehicleReservation.vue";
import VehicleList from "@/views/VehicleList.vue";
import Nav from "@/components/Navbar.vue";
import About from "@/views/About.vue";
import Signup from "@/views/Signup.vue"

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
      component: VehicleList
    },
    {
      path: '/vehicles/:id',
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
    }
  ]
})

export default router
