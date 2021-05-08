package com.cardozo.salesservice.repositories;

import com.cardozo.salesservice.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
