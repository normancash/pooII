package com.ni.salvadoritapizza.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="SUCURSAL")
public class Branch {
    @Id
    @SequenceGenerator(name = "branch_seq",
            sequenceName = "branch_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "branch_seq")
    private Long id;

    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_departamento",nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Department department;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_municipio",nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Municipio municipio;


}
