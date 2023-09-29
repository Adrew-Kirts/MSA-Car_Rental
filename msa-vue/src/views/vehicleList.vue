<script>

import Vehicle from "@/components/vehicle.vue";
import VehiclesService from '../services/VehiclesService'
import VueLoop from 'vue-loop'
export default {
  name: "vehicleList",
  components:{
    Vehicle,
    VueLoop
  },
  data(){
    return{
      vehicles: []
    }
  },
  methods:{
    getVehicles(){
      VehiclesService.getVehicles()
          .then((response)=>this.vehicles = response.data)
    }
  },
  created() {
    this.getVehicles()
  }
}
</script>

<template>

<!--  <VueLoop :full="false" :horizontal="false">-->
  <ul>
    <vehicle v-for="vehicle in vehicles"
             :key="vehicle.id"
             :registration="vehicle.registration"
             :brand="vehicle.brand"
             :model="vehicle.model"
             :color="vehicle.color"
             :fiscal-hp="vehicle.fiscalHp"
             :reservation-price="vehicle.reservationPrice">

    </vehicle>
  </ul>
<!--  </VueLoop>-->


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