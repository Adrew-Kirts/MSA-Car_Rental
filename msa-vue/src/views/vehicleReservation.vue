<script>
import vehiclesService from "@/services/VehiclesService";

export default {
  name: "vehicleReservation",
  data(){
    return{
      vehicle:{}
    }
  },
  methods:{
    getVehicle(id){
      vehiclesService.getVehicle(id)
          .then(response=>this.vehicle=response.data)
    }
  },
  created(){
    this.getVehicle(this.$route.params.id)
  }
}
</script>

<template>
<h3>{{ vehicle}}</h3>


</template>

<style scoped>

</style>