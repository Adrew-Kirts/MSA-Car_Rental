<script>

import VehicleDetails from "@/components/VehicleDetails.vue";

export default {
  name: "Vehicle",
  props: {
    id: Number,
    registration: String,
    brand: String,
    model: String,
    color: String,
    fiscalHp: Number,
    datePickup: Date,
    odometer: Number,
    dateReturn: Date,
    reservationPrice: Number,
    cleaningCost: Number,
    mileageCost: Number,
    type: String,
    displacement: Number,
    loadVolume: Number,
    lastBrakeFluidMaintenanceDate: Date,
    lastTireMaintenanceDate: Date,
    lastTimingBeltMaintenanceOdometer: Number,
    lastChainMaintenanceOdometer: Number,
    lastChainMaintenanceDate: Date,
    lastSuspensionMaintenanceDate: Date
  },
  components: {
    VehicleDetails,
  },
  data() {
    return {
      showDetails: false,
    };
  },
  methods: {
    toggleDetails() {
      this.showDetails = !this.showDetails;
    },
  },
}

</script>

<template>

  <div class="car">
    <p class="brand-model">{{ brand }} {{ model }}</p>
    <p>Price per day: ${{ reservationPrice }}</p>
    <button @click="toggleDetails">Show Details</button>
    <div v-if="showDetails">
      <p>Fiscal HP: {{fiscalHp}}</p>
      <p>Displacement: {{displacement}}</p>
      <p>Mileage cost: ${{mileageCost}} per KM</p>
      <div>
        <VehicleDetails
      ></VehicleDetails>
      </div>
      <router-link :to="{ path: '/reservation/'+id }"><button>Reserve</button></router-link>
    </div>
  </div>


</template>

