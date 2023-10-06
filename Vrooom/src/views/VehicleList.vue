<script>
import Vehicle from "@/components/Vehicle.vue";
import VehiclesService from "@/services/VehiclesService";

export default {
  name: "VehicleList",
  components: {
    Vehicle
  },
  data() {
    return {
      Vehicles: [],
      isModalOpen: false,
      selectedVehicle: null
    }
  },
  methods: {
    getVehicles() {
      VehiclesService.getVehicles(this.$route.query)
          .then((response) => this.Vehicles = response.data)
    },
    showDetails(Vehicle) {
      this.selectedVehicle = Vehicle
      this.isModalOpen = true
    },
    closeModal() {
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
    <Vehicle v-on:click="showDetails(vehicle)" v-for="vehicle in Vehicles" :key="vehicle.id"
             :vehicle="vehicle"></Vehicle>
  </ul>

  <div v-if="isModalOpen" class="fixed inset-0 flex items-center justify-center z-50">
    <div class="modal-container p-10 bg-gray-500 rounded">
      <div class="modal-content">
        <h3 class="text-6xl"><span class="text-3xl">{{ selectedVehicle.brand }}</span> {{ selectedVehicle.model }} <span
            class="text-3xl">{{ selectedVehicle.color }}</span></h3>
        <p class="text-2xl flex justify-evenly">{{ selectedVehicle.fiscalHp }} chevaux!<span
            class="price"> {{ selectedVehicle.reservationPrice }} Euro/jour</span></p>
        <p v-if="selectedVehicle.type === 'motorcycle'" class="text-2xl flex justify-evenly">
          {{ selectedVehicle.displacement }}</p>
        <!--        add cross to close-->
        <button @click="closeModal" class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded">Fermer
        </button>
        <router-link :to="{path: 'vehicles/'+selectedVehicle.id}" tag="button"
                     class="bg-emerald-500 hover:bg-emerald-600 text-white font-bold py-2 px-4 rounded">Réserver
        </router-link>
      </div>
    </div>
  </div>

</template>

<style scoped>

</style>

<!--XXXXXXXXXXXXXXXXXX-->
<!--   AVEC PINIA:    -->
<!--XXXXXXXXXXXXXXXXXX-->

<!--<script>-->
<!--import Vehicle from "@/components/Vehicle.vue";-->

<!--import {useVehicleStore} from "@/stores/VehicleStore";-->
<!--import {computed} from "vue";-->

<!--export default {-->
<!--  components: {-->
<!--    Vehicle,-->
<!--  },-->
<!--  data() {-->
<!--    return {-->
<!--      getVehicles: computed(() => {-->
<!--        return useVehicleStore().getVehicles;-->
<!--      }),-->
<!--      isModalOpen: false,-->
<!--      selectedVehicle: null-->
<!--    };-->
<!--  },-->
<!--  methods: {-->
<!--    showDetails(Vehicle) {-->
<!--      this.selectedVehicle = Vehicle-->
<!--      this.isModalOpen = true-->
<!--    },-->
<!--    closeModal() {-->
<!--      this.selectedVehicle = null-->
<!--      this.isModalOpen = false-->
<!--    }-->
<!--  },-->
<!--  mounted() {-->
<!--    const store = useVehicleStore();-->
<!--    store.fetchVehicles();-->
<!--  },-->
<!--};-->

<!--</script>-->

<!--<template>-->
<!--  -->
<!--  <div>-->
<!--    <div v-for="vehicle in getVehicles" :key="vehicle.id">-->
<!--      <div class="vehicle-card">-->
<!--        <h3>{{ vehicle.brand }} {{ vehicle.model }}</h3>-->
<!--        <p>Color: {{ vehicle.color }}</p>-->
<!--        <p>Fiscal HP: {{ vehicle.fiscalHp }}</p>-->
<!--        <p>Price: {{ vehicle.reservationPrice }} Euro/jour</p>-->

<!--        &lt;!&ndash;  Check if type = motorcycle and render add. details &ndash;&gt;-->
<!--        <template v-if="vehicle.type === 'motorcycle'">-->
<!--          <p>Displacement: {{ vehicle.displacement }}</p>-->
<!--        </template>-->

<!--        &lt;!&ndash;        Check if type = utility and render add. details&ndash;&gt;-->
<!--        <template v-if="vehicle.type === 'utility'">-->
<!--          <p>Load Volume: {{ vehicle.loadVolume }}</p>-->
<!--        </template>-->

<!--        <router-link :to="'/vehicles/' + vehicle.id" tag="button"-->
<!--                     class="bg-emerald-500 hover:bg-emerald-600 text-white font-bold py-2 px-4 rounded">Reserve-->
<!--        </router-link>-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->

<!--</template>-->

<!--<style scoped>-->

<!--.vehicle-card{-->
<!--  background-color: rgba(255, 255, 255, 0.8);-->
<!--  margin-bottom: 10px;-->
<!--}-->
<!--</style>-->