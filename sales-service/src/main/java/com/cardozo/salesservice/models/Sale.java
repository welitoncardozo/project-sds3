package com.cardozo.salesservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "sale_id")
    private Long id;

    private int viseted;
    private int deals;
    private double amount;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
}
