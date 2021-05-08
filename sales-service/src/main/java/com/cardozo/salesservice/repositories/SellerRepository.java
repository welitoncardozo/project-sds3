package com.cardozo.salesservice.repositories;

import com.cardozo.salesservice.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
