package com.cardozo.salesservice.resources;

import com.cardozo.salesservice.dtos.SaleDto;
import com.cardozo.salesservice.services.SaleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
public class SaleResource {
    private final SaleService service;

    public SaleResource(SaleService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<Page<SaleDto>> findAll(final Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }
}
