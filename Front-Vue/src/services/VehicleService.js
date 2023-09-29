import axios from 'axios';

const VEHICLE_API_BASE_URL = 'http://localhost:8086/vehicles';

class VehicleService{

    getVehicles(){
        return axios.get(VEHICLE_API_BASE_URL);
    }

}

export default new VehicleService();