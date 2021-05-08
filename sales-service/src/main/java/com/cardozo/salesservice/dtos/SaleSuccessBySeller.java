package com.cardozo.salesservice.dtos;

public record SaleSuccessBySeller(
        String getSellerName,
        long getVisited,
        long getDeals
) {
}
