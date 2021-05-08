package com.cardozo.salesservice.resources;

import com.cardozo.salesservice.dtos.SaleDto;
import com.cardozo.salesservice.dtos.SaleSuccessBySeller;
import com.cardozo.salesservice.dtos.SaleTotalBySeller;
import com.cardozo.salesservice.services.SaleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleResource {
    private final SaleService service;

    public SaleResource(SaleService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<SaleDto>> findAll(final Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/total-by-seller")
    public ResponseEntity<List<SaleTotalBySeller>> findTotalBySeller() {
        return ResponseEntity.ok(service.findTotalBySeller());
    }

    @GetMapping("/success-by-seller")
    public ResponseEntity<List<SaleSuccessBySeller>> findSuccessBySeller() {
        return ResponseEntity.ok(service.findSuccessBySeller());
    }
}
