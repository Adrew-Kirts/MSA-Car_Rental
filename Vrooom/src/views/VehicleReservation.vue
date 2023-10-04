<script>
import VehiclesService from "@/services/VehiclesService";

export default {
  name: "VehicleReservation",
  data(){
    return{
      Vehicle:{}
    }
  },
  methods:{
    getVehicle(id){
      VehiclesService.getVehicle(id)
          .then(response=>this.Vehicle=response.data)
    }
  },
  created(){
    this.getVehicle(this.$route.params.id)
  }
}
</script>

<template>
<h3>{{ Vehicle }}</h3>


</template>

<style scoped>

</style>