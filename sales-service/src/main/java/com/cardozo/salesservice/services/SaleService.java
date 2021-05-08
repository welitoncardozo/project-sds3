package com.cardozo.salesservice.services;

import com.cardozo.salesservice.dtos.SaleDto;
import com.cardozo.salesservice.dtos.SaleSuccessBySeller;
import com.cardozo.salesservice.dtos.SaleTotalBySeller;
import com.cardozo.salesservice.repositories.SaleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService {
    private final SaleRepository repository;

    public SaleService(SaleRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<SaleDto> findAll(final Pageable pageable) {
        return repository.findAll(pageable)
                .map(SaleDto::from);
    }

    public List<SaleTotalBySeller> findTotalBySeller() {
        return repository.findGroupedBySeller();
    }

    public List<SaleSuccessBySeller> findSuccessBySeller() {
        return repository.findGroupedSuccessBySeller();
    }
}
