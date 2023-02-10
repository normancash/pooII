package com.ni.salvadoritapizza.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="DETALLE_ORDER")
public class DetailOrder {

    @Id
    @SequenceGenerator(name = "detalleorder_seq",
            sequenceName = "detalleorder_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "detalleorder_seq")
    private Long id;

    //SOLAMENTE PIZZA
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_producto",nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_order",nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Order order;

    //EXTRAS
    @OneToMany(mappedBy = "detalleOrder",
            cascade  = CascadeType.ALL,fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Detail> detalles = new ArrayList<>();

    private int quantity;


}
