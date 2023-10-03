import axios from 'axios';
const VEHICLE_API_URL = import.meta.env.VITE_VEHICLE_BASE_URL


class VehicleService{

    getVehicles(){
        return axios.get(VEHICLE_API_URL+"vehicles");
    }

    getVehicleById(id){
        return axios.get(VEHICLE_API_URL+"vehicles/"+id);
    }

}

export default new VehicleService();