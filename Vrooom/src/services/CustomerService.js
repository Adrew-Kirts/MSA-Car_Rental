import axios from 'axios';

const CUSTOMER_API_URL = import.meta.env.VITE_CUSTOMER_BASE_URL;

class CustomerService {
    async postUser(userData) {
        try {
            const response = await axios.post(`${CUSTOMER_API_URL}`, userData);
            return response.data;
        } catch (error) {
            throw error;
        }
    }
}

export default new CustomerService();
