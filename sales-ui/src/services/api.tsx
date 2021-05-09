import axios from 'axios';
import { BASE_URL } from 'environments/base-url';

const api = axios.create({
  baseURL: BASE_URL
});

export default api;