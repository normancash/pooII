package com.ni.salvadoritapizza.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="DETALLE_EXTRA")
public class Detail {

    @Id
    @SequenceGenerator(name = "detalle_seq",
            sequenceName = "detalle_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "detalle_seq")
    private Long id;

    //EXTRA
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_producto",nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_detalleOrder",nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private DetailOrder detalleOrder;

    private int quantity;


}
