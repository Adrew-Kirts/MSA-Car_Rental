import axios from 'axios';

const VEHICLE_API_URL = import.meta.env.VITE_VEHICLE_BASE_URL

class VehiclesService{
    getVehicles(query){
        if(query.type === null) {
            return axios.get(VEHICLE_API_URL);
        }else if (Object.keys(query).length === 1){
            return axios.get(VEHICLE_API_URL+"?type="+query.type)
        }else{
            return axios.get(VEHICLE_API_URL+"available?type="+query.type+"&startDate="+query.startDate+"&endDate="+query.endDate)
        }

    }
    getVehicle(id){
        return axios.get(VEHICLE_API_URL+id);
    }
}

export default new VehiclesService();