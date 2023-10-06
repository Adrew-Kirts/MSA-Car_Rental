<script>
import VehiclesService from "@/services/VehiclesService";
import vehicle from "@/components/Vehicle.vue";

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
    },
    reserve(){
      if(user.connected){
        this.$router.push({
          path:'/reservation',
          body: JSON.stringify({
              rentalStart:this.date[0].format('YYYY-MM-DD') ,
              rentalEnd: this.date[1].format('YYYY-MM-DD'),
              mileageEstimation: 0,
              vehicleId: vehicle.id,
              customerId: customer.id})
        })
      }else{
        alert("You must be connected.")
      }
    }
  },
  created(){
    this.getVehicle(this.$route.query.id)
  }
}
</script>

<template>

<div id="fiche">
  <h1>HOOOOOOOOOO LE BEL OBJET!!!!</h1>
  <h3>{{ Vehicle }}</h3>
  <a-range-picker v-model:value="date"/>
  <a-button type="primary" >Submit</a-button>

</div>

</template>

<style scoped>
#fiche{
  margin-top: 200px;
  width: 100%;
  height: 60vh;
  background-color: rgba(0,0,0, .5);
  color: #2c3e50;
  border: solid 1px #41B883;
  border-radius: 10px;
  padding: 3em;
  overflow: hidden;
  overflow-y: scroll;
  box-shadow: 0 0 50px 0 #41B883 inset;
  color: white;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: center;
}


</style>