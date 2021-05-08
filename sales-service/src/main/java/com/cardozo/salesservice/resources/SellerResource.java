package com.cardozo.salesservice.resources;

import com.cardozo.salesservice.dtos.SellerDto;
import com.cardozo.salesservice.services.SellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellerResource {
    private final SellerService service;

    public SellerResource(SellerService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<SellerDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
