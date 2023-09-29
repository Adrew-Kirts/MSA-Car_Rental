import axios from 'axios';

const VEHICLE_API = 'http://192.168.1.239:8086/vehicles/';

class VehiclesService{
    getVehicles(){
        return axios.get(VEHICLE_API);
    }
}

export default new VehiclesService();