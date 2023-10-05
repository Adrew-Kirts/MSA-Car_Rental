<script>

import Vehicle from "@/components/vehicle.vue";
import VehiclesService from '../services/VehiclesService'
import vehicle from "../components/vehicle.vue";
import router from "@/router";


export default {
  name: "vehicleList",
  components:{
    Vehicle
  },
  data(){
    return{
      vehicles: [],
      isModalOpen: false,
      selectedVehicle: null
    }
  },
  methods:{
    getVehicles(){
      VehiclesService.getVehicles()
          .then((response)=>this.vehicles = response.data)
    },
    showDetails(vehicle){
      this.selectedVehicle = vehicle
      this.isModalOpen = true
    },
    closeModal(){
      this.selectedVehicle = null
      this.isModalOpen = false
    }
  },
  created() {
    this.getVehicles()
  }
}
</script>

<template>

  <ul>
    <vehicle v-on:click="showDetails(vehicle)" class="rounded" v-for="vehicle in vehicles"
             :key="vehicle.id"
             :registration="vehicle.registration"
             :brand="vehicle.brand"
             :model="vehicle.model"
             :color="vehicle.color"
             :fiscal-hp="vehicle.fiscalHp"
             :reservation-price="vehicle.reservationPrice">

    </vehicle>
  </ul>

  <div v-if="isModalOpen" class="fixed inset-0 flex items-center justify-center z-50">
    <div class="modal-container p-10 bg-gray-500 rounded">
      <div class="modal-content">
        <h3 class="text-6xl"><span class="text-3xl">{{selectedVehicle.brand}}</span> {{selectedVehicle.model}} <span class="text-3xl">{{selectedVehicle.color}}</span></h3>
        <p class="text-2xl flex justify-evenly">{{selectedVehicle.fiscalHp}} chevaux!<span class="price"> {{selectedVehicle.reservationPrice}} Euro/jour</span></p>
        <p v-if="selectedVehicle.type === 'motorcycle'" class="text-2xl flex justify-evenly">{{selectedVehicle.displacement}}</p>
        <button @click="closeModal" class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded">Fermer</button>
<!--        <button @click="{path: 'vehicleReservation', params:{selectedVehicle}}" class="bg-emerald-600 hover:bg-emerald-700 text-white font-bold py-2 px-4 rounded">Réserver</button>-->
        <router-link :to="{path: 'vehicles/'+selectedVehicle.id}" tag="button" class="bg-emerald-500 hover:bg-emerald-600 text-white font-bold py-2 px-4 rounded">Réserver</router-link>
      </div>
    </div>
  </div>

</template>

<style scoped>

vehicle{
  margin: 10px
}

ul{
  height:50vh;
}
ul{
  overflow:hidden;
  overflow-y:scroll;
}

</style>