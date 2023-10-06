const RESERVATION_API_URL = import.meta.env.VITE_RESERVATION_BASE_URL

class ReservatioService{
    addReservation(){
        return axios.post(RESERVATION_API_URL),{
            rentalStart: ,
            rentalEnd: ,
            mileageEstimation: ,
            vehicleId: ,
            customerId: ,

        }
    }
}