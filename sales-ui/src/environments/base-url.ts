const PRODUCTION = process.env.REACT_APP_BASE_URL_PRODUCTION;
const DEVELOPMENT = 'http://localhost:8080';

export const BASE_URL = PRODUCTION ?? DEVELOPMENT;