import {defineStore} from "pinia";
import axios from "axios";
const VEHICLE_API_URL = import.meta.env.VITE_VEHICLE_BASE_URL

export const useVehicleStore = defineStore('vehicleStore', {
    state: () => ({
        vehicles: [],

    }),
    getters: {
        getVehicles(state){
            return state.vehicles;
        }
    },
    actions: {
        async fetchVehicles() {
            try {
                const data = await axios.get(VEHICLE_API_URL)
                this.vehicles = data.data
            }
            catch (error) {
                alert(error)
                console.log(error)

            }
        }
    },
})



