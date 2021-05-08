package com.cardozo.salesservice.dtos;

import com.cardozo.salesservice.models.Seller;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record SellerDto(Long id, String name) implements Serializable {
    public static SellerDto from(final Seller seller) {
        return new SellerDto(seller.getId(), seller.getName());
    }
}
