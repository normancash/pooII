package com.ni.salvadoritapizza.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="PRODUCTO")
public class Product {

    @Id
    @SequenceGenerator(name = "product_seq",
            sequenceName = "product_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product_seq")
    private Long id;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private TYPEPRODUCT typeProduct;

    private float price;

}
