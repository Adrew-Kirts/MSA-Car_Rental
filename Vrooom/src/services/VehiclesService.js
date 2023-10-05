import axios from 'axios';

const VEHICLE_API_URL = import.meta.env.VITE_VEHICLE_BASE_URL

class VehiclesService{
    getVehicles(quickstart){
        if(!quickstart.isEmpty){
            return axios.get(VEHICLE_API_URL);
        }else{
            return axios.get(VEHICLE_API_URL+"available?type="+quickstart.type+"&startDate="+quickstart.startDate+"&endDate="+quickstart.endDate)
        }

    }
    getVehicle(id){
        return axios.get(VEHICLE_API_URL+id);
    }
}

export default new VehiclesService();