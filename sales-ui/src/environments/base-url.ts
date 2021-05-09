const PRODUCTION = process.env.BASE_URL_PRODUCTION;
const DEVELOPMENT = 'http://localhost:8080';

export const BASE_URL = PRODUCTION ?? DEVELOPMENT;