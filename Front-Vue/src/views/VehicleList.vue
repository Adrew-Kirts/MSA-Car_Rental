<script>


import VehicleService from "@/services/VehicleService";
import Vehicle from "@/components/Vehicle.vue";

// export default {
//   name: 'VehicleList',
//   components:{
//     Vehicle
//   },
//   data() {
//     return {
//       vehicles: []
//     }
//   },
//   methods: {
//     getVehicles(){
//       VehicleService.getVehicles().then((response) => {
//         this.vehicles = response.data;
//       });
//     }
//   },
//   created() {
//     this.getVehicles();
//   }
// }

export default {
  name: 'VehicleList',
  components: {
    Vehicle, // Register the Vehicle component
  },
  data() {
    return {
      vehicles: [],
      currentIndex: 0,
    }
  },
  methods: {
    getVehicles() {
      VehicleService.getVehicles().then((response) => {
        this.vehicles = response.data;
        this.startCarousel();
      });
    },
    startCarousel() {
      setInterval(() => {
        this.currentIndex = (this.currentIndex + 1) % this.vehicles.length;
        this.updateCarousel();
      }, 3000); // Change vehicle every 3 seconds (adjust as needed)
    },
    updateCarousel() {
      const carousel = this.$refs.carousel;
      if (carousel) {
        const width = carousel.clientWidth;
        carousel.style.transform = `translateX(-${this.currentIndex * width}px)`;
      }
    },
  },
  created() {
    this.getVehicles();
  },
};

</script>



<template>

<!--  <Vehicle v-for="vehicle in vehicles" :key="vehicle.id"-->
<!--            :brand="vehicle.brand"-->
<!--            :model="vehicle.model"-->
<!--            :name="vehicle.name"-->
<!--            :reservationPrice="vehicle.reservationPrice">-->

<!--  </Vehicle>-->

  <div class="carousel-container">
    <div class="carousel" ref="carousel">
      <Vehicle v-for="vehicle in vehicles" :key="vehicle.id"
               :brand="vehicle.brand"
               :model="vehicle.model"
               :name="vehicle.name"
               :reservationPrice="vehicle.reservationPrice">
      </Vehicle>
    </div>
  </div>


</template>



<style>

</style>