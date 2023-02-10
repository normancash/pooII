package com.ni.salvadoritapizza.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="ORDEN")
public class Order {

    @Id
    @SequenceGenerator(name = "order_seq",
            sequenceName = "order_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "order_seq")
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_cliente",nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_sucursal",nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Branch branch;

    @OneToMany(mappedBy = "order",
            cascade  = CascadeType.ALL,fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<DetailOrder> detalles = new ArrayList<>();

    private Double total;

    @Enumerated(EnumType.STRING)
    private ORDERSTATUS orderStatus;

}
