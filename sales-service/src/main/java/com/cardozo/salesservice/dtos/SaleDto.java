package com.cardozo.salesservice.dtos;

import com.cardozo.salesservice.models.Sale;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class SaleDto {
    private final Long id;
    private final int visited;
    private final int deals;
    private final double amount;
    private final LocalDate date;
    private final SellerDto sellerDto;

    public static SaleDto from(final Sale sale) {
        return SaleDto.builder()
                .id(sale.getId())
                .visited(sale.getVisited())
                .deals(sale.getDeals())
                .amount(sale.getAmount())
                .date(sale.getDate())
                .sellerDto(SellerDto.from(sale.getSeller()))
                .build();
    }
}
