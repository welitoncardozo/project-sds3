package com.cardozo.salesservice.repositories;

import com.cardozo.salesservice.dtos.SaleSuccessBySeller;
import com.cardozo.salesservice.dtos.SaleTotalBySeller;
import com.cardozo.salesservice.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    @Query("""
            SELECT new com.cardozo.salesservice.dtos.SaleTotalBySeller(seller.name, SUM(sale.amount))
              FROM Sale AS sale
              JOIN sale.seller AS seller
              GROUP BY seller
            """
    )
    List<SaleTotalBySeller> findGroupedBySeller();

    @Query("""
            SELECT new com.cardozo.salesservice.dtos.SaleSuccessBySeller(seller.name, SUM(sale.visited), SUM(sale.deals))
              FROM Sale AS sale
              JOIN sale.seller AS seller
              GROUP BY seller
            """
    )
    List<SaleSuccessBySeller> findGroupedSuccessBySeller();
}
