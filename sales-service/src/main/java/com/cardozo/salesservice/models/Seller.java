package com.cardozo.salesservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "seller_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "seller")
    private List<Sale> saleList;
}
