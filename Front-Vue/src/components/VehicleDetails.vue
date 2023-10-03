<template>


</template>

<script>
import vehicle from "./Vehicle.vue";


export default {
  components: {},
  computed: {
    vehicle() {
      return vehicle
    }
  },
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
};
</script>

<style scoped>

</style>
