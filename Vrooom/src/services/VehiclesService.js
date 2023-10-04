import axios from 'axios';

const VEHICLE_API_URL = import.meta.env.VITE_VEHICLE_BASE_URL

class VehiclesService{
    getVehicles(){
        return axios.get(VEHICLE_API_URL);
    }
    getVehicle(id){
        return axios.get(VEHICLE_API_URL+id);
    }
}

export default new VehiclesService();