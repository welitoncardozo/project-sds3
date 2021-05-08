package com.cardozo.salesservice.services;

import com.cardozo.salesservice.dtos.SellerDto;
import com.cardozo.salesservice.repositories.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class SellerService {
    private final SellerRepository repository;

    public SellerService(SellerRepository repository) {
        this.repository = repository;
    }

    public List<SellerDto> findAll() {
        return repository.findAll()
                .stream()
                .map(SellerDto::from)
                .collect(toList());
    }
}
