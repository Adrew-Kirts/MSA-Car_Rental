<script>


import VehicleService from "@/services/VehicleService";
import Vehicle from "@/components/Vehicle.vue";
import VehicleDetails from "@/components/VehicleDetails.vue";

export default {
  name: 'VehicleList',
  components:{
    VehicleDetails,
    Vehicle
  },
  data() {
    return {
      vehicles: []
    }
  },
  methods: {
    getVehicles(){
      VehicleService.getVehicles().then((response) => {
        this.vehicles = response.data;
      });
    }
  },
  created() {
    this.getVehicles();
  }
}

</script>



<template>

  <Vehicle v-for="vehicle in vehicles"
            :key="vehicle.id"
            :brand="vehicle.brand"
            :model="vehicle.model"
            :name="vehicle.name"
            :reservationPrice="vehicle.reservationPrice"
            :fiscal-hp="vehicle.fiscalHp"
            :mileage-cost="vehicle.mileageCost"
            :displacement="vehicle.displacement">
  </Vehicle>


</template>



<style>

</style>