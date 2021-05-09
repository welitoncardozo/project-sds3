import { Seller } from './seller';

export type Sale = {
  id: number;
  visited: number;
  deals: number;
  amount: number;
  date: Date;
  seller: Seller;
}

export type SalePage = {
  content?: Sale[],
  last: boolean,
  totalElements: number,
  totalPages: number,
  size?: number,
  number: number,
  first: boolean,
  numberOfElements?: number,
  empty?: boolean
}

export type SaleTotalBySeller = {
  sellerName: string;
  total: number;
}

export type SaleSuccessBySeller = {
  sellerName: string;
  visited: number;
  deals: number;
}