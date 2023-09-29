<script>

export default {
  name: "Vehicle",
  props: {
    id: Number,
    registration: String,
    brand: String,
    model: String,
    color: String,
    fiscalHp: Number,
    datePickup: Date, // Attention (localDate est donné)
    odometer: Number,
    dateReturn: Date, // Attention (localDate est donné)
    reservationPrice: Number,
    cleaningCost: Number,
    mileageCost: Number,
    type: String,
    displacement: Number,
    loadVolume: Number,
    lastBrakeFluidMaintenanceDate: Date, // Attention (localDate est donné)
    lastTireMaintenanceDate: Date, // Attention (localDate est donné)
    lastTimingBeltMaintenanceOdometer: Number,
    lastChainMaintenanceOdometer: Number,
    lastChainMaintenanceDate: Date, // Attention (localDate est donné)
    lastSuspensionMaintenanceDate: Date // Attention (localDate est donné)
  }
}

</script>

<template>

<!--  <div class="list">-->
<!--    <div class="car">-->
<!--      <p class="brand-model">{{ this.brand }} {{ this.model }}</p>-->
<!--      <p>Price per day: ${{ this.reservationPrice }}</p>-->
<!--    </div>-->
<!--  </div>-->

<!--  <div class="carousel-container">-->
<!--    <div class="carousel">-->
<!--      <div class="car" v-for="car in cars" :key="car.id">-->
<!--        <p class="brand-model">{{ car.brand }} {{ car.model }}</p>-->
<!--        <p>Price per day: ${{ car.reservationPrice }}</p>-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->


<!--      <div class="car" v-for="vehicle in vehicles" :key="vehicle.id">-->
<!--        <p class="brand-model">{{ vehicle.brand }} {{ vehicle.model }}</p>-->
<!--        <p>Price per day: ${{ vehicle.reservationPrice }}</p>-->
<!--      </div>-->

  <div class="car">
    <p class="brand-model">{{ brand }} {{ model }}</p>
    <p>Price per day: ${{ reservationPrice }}</p>
  </div>

</template>
